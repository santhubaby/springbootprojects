package in.ashokit.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;

@Component
public class Jwtauthfilter implements GlobalFilter {

    private static final Logger log = LoggerFactory.getLogger(Jwtauthfilter.class);

    @Autowired
    private Jwtservice jwtUtil;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        String authHeader = request.getHeaders().getFirst(HttpHeaders.AUTHORIZATION);

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7);
            try {
                Claims claims = jwtUtil.validateToken(token);

                String username = claims.getSubject(); // "ramya"
                List<String> roles = claims.get("roles", List.class);
                String rolesHeader = roles == null ? "" : String.join(",", roles);

                ServerHttpRequest modifiedRequest = request.mutate()
                        .header("X-User", username)
                        .header("X-Roles", rolesHeader)
                        .build();

                System.out.println("Forwarding request for user {} with roles {}:"+ username + "roles:" + rolesHeader);

                return chain.filter(exchange.mutate().request(modifiedRequest).build());

            } catch (JwtException e) {
                System.out.println("JWT validation failed"+ e);
                exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                return exchange.getResponse().setComplete();
            }
        }

        // Reject if no token
        exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
        System.out.println("no token received");
        return exchange.getResponse().setComplete();
    }
}
