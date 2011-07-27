package jndi;

import java.util.Hashtable;
import java.util.Set;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import java.util.Map.Entry;

public class TestJndi {

	public static void main(String[] args) throws NamingException {
		Hashtable<String, String> env = new Hashtable<String, String>();
		env.put(Context.INITIAL_CONTEXT_FACTORY,
				"com.sun.jndi.ldap.LdapCtxFactory");
		env.put(Context.PROVIDER_URL,
				"ldap://172.22.250.61:10389/dc=presidencia,dc=gob,dc=mx");

		DirContext ctx = new InitialDirContext(env);
		Set entrySet;
		entrySet = ctx.getEnvironment().entrySet();
		Entry entry;
		for (Object object : entrySet) {
			entry = (Entry) object;
			System.out.println(entry.getValue());
		}
		// System.out.println(ctx);
	}

}
