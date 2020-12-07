github上更改配置文件config-dev.yml  
###全局刷新
打开cmd，输入curl -X POST "http://localhost:3344/actuator/bus-refresh" 
###定点刷新
打开cmd，输入curl -X POST "http://localhost:3344/actuator/bus-refresh/confg-client:3355"  
###测试
浏览器访问：  
http://config-3344.com:3344/config-dev.yml  
http://localhost:3355/configInfo  
http://localhost:3366/configInfo  
