import java.io.Serializable;

public class Ciphermessage implements Serializable
{
String prefix;
byte[] message;

public Ciphermessage(String pre,String msg)
{
	prefix = pre;
	message = security.encrypt(msg, website.key);
}

}
