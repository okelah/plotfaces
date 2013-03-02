/*
 * Copyright 2013 Graham.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.plotfaces.component;

import com.google.javascript.jscomp.Compiler;
import com.google.javascript.jscomp.CompilerOptions;
import com.google.javascript.jscomp.SourceFile;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Graham
 */
public class Optimizer {
	
	public Optimizer() {
	}

	public String optimize(String javascript, RendererOptions options) {
		Compiler compiler = new Compiler();

		CompilerOptions compilerOptions = new CompilerOptions();
		options.getCompilationLevel().setOptionsForCompilationLevel(compilerOptions);
		compilerOptions.setPrettyPrint(true);

		// To get the complete set of externs, the logic in
		// CompilerRunner.getDefaultExterns() should be used here.
		List<SourceFile> externs = new ArrayList<SourceFile>();
		//The Closure compiler blows up if provided with null externs!
		if( options.getExterns() != null ) {
			externs.add(SourceFile.fromCode("externs.js",options.getExterns()));
		}

		// The dummy input name "input.js" is used here so that any warnings or
		// errors will cite line numbers in terms of input.js.
		List<SourceFile> inputs = new ArrayList<SourceFile>();
		inputs.add(SourceFile.fromCode("input.js", javascript));

		compiler.compile(externs, inputs, compilerOptions);

		// The compiler is responsible for generating the compiled code; it is not
		// accessible via the Result.
		return compiler.toSource();
	}
}
