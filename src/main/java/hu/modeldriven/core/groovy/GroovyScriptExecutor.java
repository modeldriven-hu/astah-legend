package hu.modeldriven.core.groovy;

import groovy.lang.Binding;
import groovy.lang.GroovyShell;

public class GroovyScriptExecutor implements ScriptExecutor {

    @Override
    public Object execute(String script, String argumentKey, Object argumentValue) throws ScriptExecutionException {

        System.err.println("Executing script " + script + " with key: " + argumentKey + ", value: " + argumentValue);

        Binding binding = new Binding();
        binding.setVariable(argumentKey, argumentValue);
        GroovyShell shell = new GroovyShell(binding);
        try {
            return shell.evaluate(script);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new GroovyScriptExecutionException(ex);
        }
    }
}
