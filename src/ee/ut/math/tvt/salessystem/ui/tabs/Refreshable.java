package ee.ut.math.tvt.salessystem.ui.tabs;

import java.awt.Component;

import ee.ut.math.tvt.salessystem.domain.controller.SalesDomainController;

public interface Refreshable {
	
	public void refresh();
	public Component draw();
	
}