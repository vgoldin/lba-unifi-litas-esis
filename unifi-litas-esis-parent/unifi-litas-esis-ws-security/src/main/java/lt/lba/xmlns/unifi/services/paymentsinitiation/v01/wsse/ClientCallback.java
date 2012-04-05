package lt.lba.xmlns.unifi.services.paymentsinitiation.v01.wsse;

import java.io.IOException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.ws.security.WSPasswordCallback;

public class ClientCallback implements CallbackHandler {

	public void handle(Callback[] callbacks) throws IOException,
			UnsupportedCallbackException {
        for (int i = 0; i < callbacks.length; i++) {
            WSPasswordCallback pwcb = (WSPasswordCallback)callbacks[i];
            String id = pwcb.getIdentifier();
            int usage = pwcb.getUsage();
            if (usage == WSPasswordCallback.DECRYPT || usage == WSPasswordCallback.SIGNATURE) {
                
                // used to retrieve password for private key
                if ("clientkey".equals(id)) {
                    pwcb.setPassword("clientpass");
                }
                
            }
        }
	}
}