import com.sap.gateway.ip.core.customdev.util.Message;
import java.util.HashMap;
import groovy.json.*;

def Message processData(Message message) {

    def body = message.getBody();
    def jsonParser = new JsonSlurper()
    def json = jsonParser.parseText(body)

    def find = json.Results.removeIf{it.metadata.dt_desligamento == 'sua data'}
    
    message.setBody(JsonOutput.toJson(json)) //passa o header Content-Type : application/json que gera o json formatado, assim evita de utilar o JsonOutput Prettyprint
    
    return message;
}