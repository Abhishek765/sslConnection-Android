# sslConnection-Android
A basic Android demonstrates ssl connection(or HTTPS connection) between provided server and client(App)<h1>COMMANDS</h1>

# steps to create the keystore file:
 # - commands<br>
      - keytool -genkey -alias codeproject -keystore C:\codeproject\codeprojectssl.keystore -validity 365
      - keytool -export -alias codeproject -keystore C:\codeproject\codeprojectssl.keystore -file C:\codeproject\codeprojectsslcert.cer
      - keytool -import -alias codeproject -file C:\codeproject\codeprojectsslcert.cer -keystore C:\codeproject\codeprojectssl.bks -storetype BKS -providerClass org.bouncycastle.jce.provider.BouncyCastleProvider -providerpath C:\codeproject\bcprov-jdk15on-146.jar
