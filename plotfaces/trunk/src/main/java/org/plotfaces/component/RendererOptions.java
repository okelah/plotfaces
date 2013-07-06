/*
 * Copyright 2013 Graham Smith.
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

import com.google.javascript.jscomp.CompilationLevel;

/**
 *
 * @author Graham Smith
 */
@Deprecated
public class RendererOptions {

	private boolean useOptimizer = false;
	private CompilationLevel compilationLevel = CompilationLevel.SIMPLE_OPTIMIZATIONS;
	private boolean prettyPrint = false;
	private String externs;

	public RendererOptions() {
	}

	public RendererOptions(boolean useOptimizer) {
		this.useOptimizer = useOptimizer;
	}

	public boolean isUseOptimizer() {
		return useOptimizer;
	}

	public void setUseOptimizer(boolean useOptimizer) {
		this.useOptimizer = useOptimizer;
	}

	public CompilationLevel getCompilationLevel() {
		return compilationLevel;
	}

	public void setCompilationLevel(CompilationLevel compilationLevel) {
		this.compilationLevel = compilationLevel;
	}

	public boolean isPrettyPrint() {
		return prettyPrint;
	}

	public void setPrettyPrint(boolean prettyPrint) {
		this.prettyPrint = prettyPrint;
	}

	public String getExterns() {
		return externs;
	}

	/**
	 * Indicates external function names that should be preserved in the source
	 * code when performing advanced optimization.
	 *
	 * @param externs
	 */
	public void setExterns(String externs) {
		this.externs = externs;
	}
}
