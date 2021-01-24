package exam;

import java.net.Socket;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;

/**
 * Your organization makes mlib. jar available to your cloud customers. While working on a new feature for mlib.jar, you see that the
 * customer visible method
 */
public class Policy {
    private Socket transportSocket;

    public void enableService(String hostName, String portNumber) {
//    executes this code fragment
        try {
            AccessController.doPrivileged((PrivilegedExceptionAction<Void>) () -> {
                transportSocket = new Socket(hostName, Integer.parseInt(portNumber));
                return null;
            });
        } catch (PrivilegedActionException e) {
            e.printStackTrace();
        }
    }
}

//  and you see that this grant is in the security policy file:

/**
 * What security vulnerability does this expose to your cloud customer's code?
 *
 * A) none because the customer code base must also be granted SocketPermission
 * B) SQL injection attack against the specified host and port
 * C) XML injection attack against any mlib server
 * D) privilege escalation attack against the OS running the customer code
 * E) denial of service attack against any reachable machine
 *
 * Answer E - because we didn't close socket
 */