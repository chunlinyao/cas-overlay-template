import org.apereo.cas.authentication.*
import org.apereo.cas.authentication.credential.*
import org.apereo.cas.authentication.metadata.*

import javax.security.auth.login.*

def authenticate(final Object... args) {
    def authenticationHandler = args[0]
    def credential = args[1]
    def servicesManager = args[2]
    def principalFactory = args[3]
    def logger = args[4]              

    /*
     * Figure out how to verify credentials...
     */
    if (authenticationWorksCorrectly()) {
        def principal = principalFactory.createPrincipal(credential.username);
        return new DefaultAuthenticationHandlerExecutionResult(authenticationHandler,
                new BasicCredentialMetaData(credential),
                principal,
                new ArrayList<>(0));
    }
    throw new FailedLoginException();
}
def authenticationWorksCorrectly() {
    return true
}

def supportsCredential(final Object... args) {
    def credential = args[0]
    def logger = args[1]
    return credential != null
}

def supportsCredentialClass(final Object... args) {
    def credentialClazz = args[0]
    def logger = args[1]
    return credentialClazz == UsernamePasswordCredential.class
}

