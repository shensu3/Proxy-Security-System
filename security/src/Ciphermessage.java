import java.io.Serializable;
import java.security.Key;

public class Ciphermessage implements Serializable
{
String prefix;
byte[] message;

public Ciphermessage(String pre,String msg,Key key)
{
	prefix = pre;
	message = security.encrypt(msg,key);
}

}
