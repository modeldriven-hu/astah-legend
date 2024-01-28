package hu.modeldriven.core.groovy;

import groovy.lang.Binding;
import groovy.lang.GroovyShell;

import java.util.Map;

public class GroovyScriptExecutor implements ScriptExecutor {

    @Override
    public Object execute(String script, Map<String, Object> arguments) throws ScriptExecutionException {

        Binding binding = new Binding();

        for (Map.Entry<String, Object> entry : arguments.entrySet()) {
            binding.setVariable(entry.getKey(), entry.getValue());
        }

        GroovyShell shell = new GroovyShell(binding);
        try {
            return shell.evaluate(script);
        } catch (Exception ex) {
            throw new GroovyScriptExecutionException(ex);
        }
    }
}
