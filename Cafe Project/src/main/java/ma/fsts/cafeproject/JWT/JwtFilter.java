//package ma.fsts.cafeproject.JWT;
//
//import io.jsonwebtoken.Claims;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import java.io.IOException;
//
//@Component
//public class JwtFilter extends OncePerRequestFilter {
//
//    @Autowired
//    JWTUtil jwtUtil;
//
//    @Autowired
//    private CustomerUserDetailsService service;
//    Claims claims = null;
//    private String username = null;
//    @Autowired
//    private HttpServletRequest httpServletRequest;
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest httpServletrequest, HttpServletResponse httpServletresponse, FilterChain filterChain) throws ServletException, IOException {
//        if (httpServletrequest.getServletPath().matches("/user/login|/user/forgotPassword|/user/signup")) {
//            filterChain.doFilter(httpServletrequest, httpServletresponse);
//        } else {
//            String authorizationHeader = httpServletrequest.getHeader("Authorization");
//            String token = null;
//            if (authorizationHeader != null && authorizationHeader.startsWith("bearer ")) {
//                token = authorizationHeader.substring(7);
//                username = jwtUtil.extractUsername(token);
//                claims = jwtUtil.extractAllClaims(token);
//            }
//            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//                UserDetails userdetails = service.loadUserByUsername(username);
//                if (jwtUtil.validateToken(token, userdetails)) {
//                    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
//                            new UsernamePasswordAuthenticationToken(userdetails, null, userdetails.getAuthorities());
//
//                    usernamePasswordAuthenticationToken.setDetails(
//                            new WebAuthenticationDetailsSource().buildDetails(httpServletRequest)
//                    );
//                    SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
//                }
//            }
//            filterChain.doFilter(httpServletrequest, httpServletresponse);
//        }
//    }
//
//    public String getCurrentUser(){
//        return username ;
//    }
//}
