package com.mvc.controllers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class Functions {

	public Functions() {
	}

	public void buscar(JTable tabla, String buscar, int... cols) {

		TableRowSorter<TableModel> sorter = new TableRowSorter<>(tabla.getModel());
		tabla.setRowSorter(sorter);
		sorter.setRowFilter(RowFilter.regexFilter("(?i)" + buscar, cols));
		// (?i) = case-insensitive

	}

	public int getSelectedId(JTable table) {

		int row = table.getSelectedRow();

		if (row > -1) {
			return (int) table.getValueAt(row, 0);
		} else {
			return 0;
		}

	}

}
