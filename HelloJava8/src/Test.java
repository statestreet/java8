import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Test {

	public static void main(String[] args) throws ScriptException,
			FileNotFoundException, NoSuchMethodException {
		// PersonFactory<Person> p = Person::new;
		// Person pp=p.create("asf", "ddd");
		// Something something = new Something();
		//
		// Converter<String, String> converter = something::startsWith;
		// String converted = converter.convert("123");
		// System.out.println(converted);

		// ScriptEngineManager manager = new ScriptEngineManager();
		// ScriptEngine engine = manager.getEngineByName("nashorn");
		//
		// String js;
		//
		// js = "var map = Array.prototype.map \n";
		// js += "var names = [\"john\", \"jerry\", \"bob\"]\n";
		// js +=
		// "var a = map.call(names, function(name) { return name.length() })\n";
		// js += "print(a)";
		//
		// engine.eval(js);

		ScriptEngine engine = new ScriptEngineManager()
				.getEngineByName("nashorn");
		engine.eval(new FileReader(
				"/Users/Charlie/Documents/workspace/HelloJava8/src/script.js"));

		Invocable invocable = (Invocable) engine;

		Object result = invocable.invokeFunction("fun1", "Peter Parker");
		System.out.println(result);
		System.out.println(result.getClass());
	}
}
