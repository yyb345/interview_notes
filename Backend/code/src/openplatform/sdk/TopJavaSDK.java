package openplatform.sdk;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.velocity.Template;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.VelocityContext;

import java.io.StringWriter;
import java.util.Properties;

public class TopJavaSDK {


    public static Map<String,Object> getApiObject(String fileName){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // 获取资源文件的路径
           String path = TopJavaSDK.class.getClassLoader().getResource(fileName).getPath();
            // 将路径转换为 File 对象
            // 读取 JSON 文件并转换为 Map
            Map<String, Object> map = objectMapper.readValue(new File(path), Map.class);
            return map;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new HashMap<>();
    }


    public static String generateJavaCode(Map<String,Object> varMap,String fileName){

        // 创建 Velocity 引擎
        Properties properties = new Properties();
        properties.setProperty("resource.loader", "class");
        properties.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");

        VelocityEngine velocityEngine = new VelocityEngine(properties);
        velocityEngine.init();

        // 创建上下文并添加数据
        VelocityContext context = new VelocityContext(varMap);

        // 加载模板
        Template template = velocityEngine.getTemplate(fileName);

        // 渲染模板
        StringWriter writer = new StringWriter();
        template.merge(context, writer);

        // 输出结果
        return writer.toString();
    }

    public static void main(String[] args) {
        Map<String, Object> apiObject = getApiObject("templates/api.json");
        String javaCode = generateJavaCode(apiObject,"templates/java.vm");
        System.out.println(javaCode);
    }
}
