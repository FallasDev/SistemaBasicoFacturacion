package com.init;

import com.formdev.flatlaf.intellijthemes.FlatCarbonIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatGradiantoDeepOceanIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatLightFlatIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatMonocaiIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMonokaiProContrastIJTheme;
import com.mvc.controllers.ControllerNavegacion;

public class Main {
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		
		new FlatLightFlatIJTheme().install();
		
		new ControllerNavegacion().init();
		
	}
}
