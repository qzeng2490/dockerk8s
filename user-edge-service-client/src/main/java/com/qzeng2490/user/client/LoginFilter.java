//package com.qzeng2490.user.client;
//
//import com.google.common.cache.Cache;
//import com.google.common.cache.CacheBuilder;
//import com.qzeng2490.thrift.user.dto.UserDTO;
//import org.apache.commons.lang.StringUtils;
//import org.apache.http.HttpResponse;
//import org.apache.http.HttpStatus;
//import org.apache.http.client.HttpClient;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.impl.client.DefaultHttpClient;
//import org.codehaus.jackson.map.ObjectMapper;
//
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.concurrent.TimeUnit;
//
///**
// * Created by liming
// */
//public abstract class LoginFilter implements Filter {
//
//    private static Cache<String, UserDTO> cache =
//            CacheBuilder.newBuilder().maximumSize(10000)
//            .expireAfterWrite(3, TimeUnit.MINUTES).build();
//
//
//    public void init(FilterConfig filterConfig) throws ServletException {
//
//    }
//
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//
//
//        System.out.println("+++++++++++In doFilter");
//
//        HttpServletRequest request = (HttpServletRequest)servletRequest;
//        HttpServletResponse response = (HttpServletResponse)servletResponse;
//
//        String token = request.getParameter("token");
//        if(StringUtils.isBlank(token)) {
//            Cookie[] cookies = request.getCookies();
//            if(cookies!=null) {
//                for(Cookie c : cookies) {
//                    if(c.getName().equals("token")) {
//                        token = c.getValue();
//                    }
//                }
//            }
//        }
//
//        UserDTO userDTO = null;
//        if(StringUtils.isNotBlank(token)) {
//            userDTO = cache.getIfPresent(token);
//            if(userDTO==null) {
//                userDTO = requestUserInfo(token);
//                if(userDTO!=null) {
//                    cache.put(token, userDTO);
//                }
//            }
//        }
//
//        if(userDTO==null) {
//            System.out.println("---sendRedirect: http://127.0.0.1:8180/user/login");
//            response.sendRedirect("http://127.0.0.1:8180/user/login");
//            return;
//        }
//
//        login(request, response, userDTO);
//
//        filterChain.doFilter(request, response);
//    }
//
//    protected abstract String userEdgeServiceAddr();
//
//    protected abstract void login(HttpServletRequest request, HttpServletResponse response, UserDTO userDTO);
//
//    private UserDTO requestUserInfo(String token) {
//        String url = "http://"+userEdgeServiceAddr()+"/user/authentication";
//
//        HttpClient client = new DefaultHttpClient();
//        System.out.println("---url:"+url);
//        HttpPost post = new HttpPost(url);
//        post.addHeader("token", token);
//        InputStream inputStream = null;
//        try {
//            HttpResponse response = client.execute(post);
//            if(response.getStatusLine().getStatusCode()!= HttpStatus.SC_OK) {
//                throw new RuntimeException("request user info failed! StatusLine:"+response.getStatusLine());
//            }
//            inputStream = response.getEntity().getContent();
//            byte[] temp = new byte[1024];
//            StringBuilder sb = new StringBuilder();
//            int len = 0;
//            while((len = inputStream.read(temp))>0) {
//                sb.append(new String(temp,0,len));
//            }
//
//            UserDTO userDTO = new ObjectMapper().readValue(sb.toString(), UserDTO.class);
//            return userDTO;
//        } catch (IOException e) {
//            e.printStackTrace();
//            System.out.println("url:"+url);
//        } finally {
//            System.out.println("url:"+url);
//            if(inputStream!=null) {
//                try{
//                    inputStream.close();
//                }catch(Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//        return null;
//    }
//
//    public void destroy() {
//
//    }
//}
