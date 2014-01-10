@Echo off
cd D:\workspace-sts\my-lib 
mvn -B clean install -Dmaven.test.skip=true
cd D:\workspace-sts\my-svc
mvn -B clean install -Dmaven.test.skip=true
cd D:\workspace-sts\my-web
mvn -B clean install -Dmaven.test.skip=true