package jalilspringproject.workflow_monitoring_app.util.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.HandlerInterceptor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class LoggingInterceptor implements HandlerInterceptor {

    private final LoggingHolder loggingHolder;

    private static final Logger log = LogManager.getLogger(LoggingInterceptor.class);

    public LoggingInterceptor(LoggingHolder loggingHolder) {
        this.loggingHolder = loggingHolder;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        try {
//            String token = request.getHeader("Authorization");
//            Map<String, String> tokenValue = JwtUtil.getValueFromToken(token, new String[]{"nip", "username", "given_name", "preferred_username", "role", "kode_kantor"});
//            String nip = tokenValue.getOrDefault("nip", "");
//            String name = tokenValue.getOrDefault("preferred_username", "");
//            String kodeKantor = tokenValue.getOrDefault("kode_kantor", "");
            String remoteAddress = request.getRemoteAddr() == null ? "127.0.0.1" : request.getRemoteAddr();
            String endPointPath = request.getRequestURI() == null ? "" : request.getRequestURI();
            String param = request.getQueryString() == null ? "" : request.getQueryString();
            Package pkg = getClass().getPackage();
            String packageName = pkg.getName();
//            String version = versionApp != null ? versionApp : "Version not available";

            LocalDateTime currentDateTime = LocalDateTime.now();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

            // Format the LocalDateTime to a string
            String formattedDateTime = currentDateTime.format(formatter);

//            loggingHolder.setPackageName(packageName);
            loggingHolder.setDate(formattedDateTime);
//            loggingHolder.setFrom(remoteAddress);
//            loggingHolder.setUserInhouse(String.format("User Inhouse: nip=%s, kodeKantor=%s", nip, kodeKantor));
//            loggingHolder.setUserPortal(String.format("User Portal: npwp=%s, name=%s", nip, name));
//            loggingHolder.setNip(nip);
//            loggingHolder.setName(name);
            loggingHolder.setPath(endPointPath);
//            loggingHolder.setData(param);
//            loggingHolder.setVersion(version);
//            log.info("App: {}, Date: {}, From: {}, User Inhouse: nip={}, kodeKantor={}, User Portal: npwp={}, nama={}, Path: {}, Data: {}, Version: {}",
//                    packageName, formattedDateTime, remoteAddress, nip, kodeKantor, nip, name, endPointPath, param, version);
            return true;
        } catch (Exception e) {
            logError("Error in LoggingInterceptor", e);
            return false;
        }
    }

    public void logError(String message, Throwable throwable) {
        log.error(message, throwable);
    }
}
