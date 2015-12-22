# Introduction #
PlotFaces is a suite of JSF components built on top of the excellent [jqPlot](http://www.jqplot.com/) JavaScript charting library. Our aim is to make PlotFaces simple to install and simple to use whilst also exposing all of the power of jqPlot.

PlotFaces is built from the ground up for JSF 2.0.

# Goals #
## Initial Release ##
  * Provide line, bar, pie and meter charts.
  * Provide a simple but powerful API for working with charts.
  * Expose most or all of the options for supported chart types.
  * Maintain full compatibility with PrimeFaces.

## Future Release ##
  * Provide access to all chart types.

# Discussion #

PlotFaces takes a different, more code based, approach compared to other JSF charting libraries and as such you won't see hundreds of attributes on the JSF chart tags. For simple charts an attribute base approach to configuration works very well. For example a page author could specify the x-axis label with an attribute like this xaxislabel="foo" without ever coming near the code. The problem comes though when you want to expose twenty different axis options for eleven different axes - yes, this is possible with jqPlot.

To get around this attribute explosion PlotFaces will provide an API that allows the user to build the chart options quickly and simply in code and link them through a single attribute. On the face of it this seems to defeat the point of using JSF since the whole idea is not to write display code. Our belief though is that charts are often a special case in an application. Before a chart can be added to a page a data model must already be provided which requires coding. Adding an options "model" as well shouldn't cause a great deal of extra work but at the same time allows the use of all the jqPlot options. Further, since the options are independent of the model they can be re-used on multiple charts.

# Links #

  * Project Home: http://www.plotfaces.org (coming soon)
  * Demonstration: http://demo.plotfaces.org (coming soon)
  * Personal Website (Graham Smith): http://www.wobblycogs.co.uk