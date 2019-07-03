package extension;

import com.pdffiller.entity.User;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

public class CustomParameterExtension implements ParameterResolver {
    private static final String INVALID_EMAIL = "invalid@invalid.com";
    private static final String INVALID_PWD = "0000000000";

    @Override
    public boolean supportsParameter(ParameterContext parameterContext,
                                     ExtensionContext extensionContext)
            throws ParameterResolutionException {
        return true;
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext,
                                   ExtensionContext extensionContext)
            throws ParameterResolutionException {
        return new User().withEmail(INVALID_EMAIL).withPwd(INVALID_PWD);
    }
}

