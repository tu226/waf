package info.yangguo.waf;

import com.codahale.metrics.MetricRegistry;
import com.google.common.collect.Lists;
import info.yangguo.waf.util.PropertiesUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.HttpMessage;
import io.netty.handler.codec.http.HttpRequest;

import java.util.List;
import java.util.Map;

/**
 * @author:杨果
 * @date:2017/4/11 下午1:52
 * <p>
 * Description:
 */
public class Constant {
    enum X_Frame_Options {
        DENY,//表示该页面不允许在 frame 中展示,即便是在相同域名的页面中嵌套也不允许.
        SAMEORIGIN//表示该页面可以在相同域名页面的 frame 中展示.
    }

    public static final MetricRegistry metrics = new MetricRegistry();
    public static Map<String, String> wafWebConfs = PropertiesUtil.getProperty("application.properties");
    public static Map<String, String> wafConfs = PropertiesUtil.getProperty("waf.properties");
    public static int AcceptorThreads = Integer.parseInt(wafConfs.get("waf.acceptorThreads"));
    public static int ClientToProxyWorkerThreads = Integer.parseInt(wafConfs.get("waf.clientToProxyWorkerThreads"));
    public static int ProxyToServerWorkerThreads = Integer.parseInt(wafConfs.get("waf.proxyToServerWorkerThreads"));
    public static int ServerPort = Integer.parseInt(wafConfs.get("waf.serverPort"));
    public static int IdleConnectionTimeout = Integer.valueOf(wafConfs.get("waf.idleConnectionTimeout"));
    public final static X_Frame_Options X_Frame_Option = X_Frame_Options.SAMEORIGIN;
}
