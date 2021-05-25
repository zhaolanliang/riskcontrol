package com.ruban.groovy;

import java.io.IOException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import groovy.lang.Binding;
import groovy.util.GroovyScriptEngine;
import groovy.util.ResourceException;
import groovy.util.ScriptException;

@RestController
public class GroovyController {
	
	@RequestMapping("/groovy/hello")
	public String getGroovyHello() throws IOException, ResourceException, ScriptException {
		GroovyScriptEngine engine = new GroovyScriptEngine("src/main/resources/shell");
		Binding binding = new Binding();
		binding.setVariable("name", "张咪咪");
		
		Object result1 = engine.run("GroovyShell_3_1.groovy", binding);
		return result1.toString();
	}
}
