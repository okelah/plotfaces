package org.plotfacesdemo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;
import org.plotfaces.data.PlotData;
import org.plotfaces.model.Axis;
import org.plotfaces.model.Grid;
import org.plotfaces.model.Highlighter;
import org.plotfaces.model.Legend;
import org.plotfaces.model.Model;
import org.plotfaces.model.Series;
import org.plotfaces.model.Title;
import org.plotfaces.renderer.AxisLabelRenderer;
import org.plotfaces.renderer.CanvasAxisTickRenderer;
import org.plotfaces.renderer.CanvasGridRenderer;
import org.plotfaces.renderer.DefaultMarkerRenderer;
import org.plotfaces.renderer.DefaultTickFormatter;
import org.plotfaces.renderer.DivTitleRenderer;
import org.plotfaces.renderer.EnhancedLegendRenderer;
import org.plotfaces.renderer.LineRenderer;
import org.plotfaces.renderer.LinearAxisRenderer;
import org.plotfacesdemo.models.BarChart;
import org.plotfacesdemo.models.Example;
import org.plotfacesdemo.models.LineChart;
import org.plotfacesdemo.models.ModelFactory;
import org.slf4j.Logger;

/**
 *
 * @author Graham Smith
 */
@Named
@SessionScoped
public class Demo implements Serializable {

	@Inject
	private Logger logger;
	private Example selectedExample;
	private ModelFactory modelFactory;
	private CollapseHandler collapseHandler = new CollapseHandler();

	public Demo() {
		try {
			modelFactory = Example.LINE_CHART.getModelFactory();
		} catch (IllegalAccessException | InstantiationException ex) {
			logger.error("Failed to create new model factory", ex);
		}
	}

	public Model getModel() {
		return modelFactory.getModel();
	}

	public CollapseHandler getCollapseHandler() {
		return collapseHandler;
	}

	public void initHighlighter() {
		System.out.println("Work damn you");
		logger.debug("Initializing Highlighter");
		Highlighter highlighter = new Highlighter();
		highlighter.setShow(true);
		highlighter.setMarkerRendererOptions(new DefaultMarkerRenderer());
		modelFactory.getModel().setHighlighter(highlighter);
	}

	public Example[] getExamples() {
		return Example.values();
	}

	public Example getSelectedExample() {
		return selectedExample;
	}

	public void setSelectedExample(Example selectedExample) {
		this.selectedExample = selectedExample;
		try {
			modelFactory = this.selectedExample.getModelFactory();
		} catch (IllegalAccessException | InstantiationException ex) {
			logger.error("Failed to create new model factory", ex);
		}

	}
}
