The jqPlot JavaScript resources are merged and minified using Google Closure
Compiler.

Note: The mobile plugin shouldn't be included in the minified version of the
libraries as it traps mouse movements and causes (at least) the highlighter
plugin to stop working.

Note to self... there is a copy of Closure Compile on the Desktop along with a
couple of scripts for compiling all the jqPlot libraries. Remember the jqPlot
main library must be the first item in the list of resources compressed / merged
together! Don't just specify the files in alphabetical order.