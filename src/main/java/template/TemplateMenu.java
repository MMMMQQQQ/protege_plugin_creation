package template;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import org.apache.log4j.Logger;
import org.protege.editor.core.ProtegeManager;
import org.protege.editor.owl.model.OWLWorkspace;
import org.protege.editor.owl.model.selection.OWLSelectionModel;
import org.protege.editor.owl.model.selection.OWLSelectionModelListener;
import org.protege.editor.owl.ui.OWLWorkspaceViewsTab;
import org.protege.editor.owl.ui.action.ProtegeOWLAction;
import org.protege.owlapi.apibinding.ProtegeOWLManager;
import org.semanticweb.owlapi.model.OWLEntity;

import bsh.org.objectweb.asm.Label;

/**
 * This plugin doesn't really do much and is intended to be deleted when a
 * developer creates his own content.
 * 
 * @author redmond
 *
 */
public class TemplateMenu extends OWLWorkspaceViewsTab {
	private static final long serialVersionUID = 749843192372192393L;
	private Logger logger = Logger.getLogger(TemplateMenu.class);
	private JLabel label;
	private OWLSelectionModel selectionModel;
	private OWLSelectionModelListener listener = new OWLSelectionModelListener() {

		@Override
		public void selectionChanged() throws Exception {
			// TODO Auto-generated method stub
			OWLEntity entity = getOWLEditorKit().getOWLWorkspace().getOWLSelectionModel().getSelectedEntity();
			updateView(entity);

		}
	};

	@Override
	public void initialise() {
		super.initialise();
		setToolTipText("Example");
		label = new JLabel("Hello World!");
		setLayout(new BorderLayout());
		add(label, BorderLayout.CENTER);
		selectionModel = getOWLEditorKit().getOWLWorkspace().getOWLSelectionModel();
		selectionModel.addListener(listener);
	}

	@Override
	public void dispose() {
	}

	private void updateView(OWLEntity e) {
		if (e != null) {
			String entityName = getOWLModelManager().getRendering(e);
			label.setText("Hello World! Selected entity= " + entityName);
		} else {
			label.setText("Hello World!");
		}
	}

	// public void actionPerformed(ActionEvent event) {
	// logger.info("Template menu plugin invoked");
	// OWLWorkspace workspace = getOWLWorkspace();
	// OWLEntity selectedEntity =
	// workspace.getOWLSelectionModel().getSelectedEntity();
	// String message;
	// if (selectedEntity != null) {
	// message = "Hello world! Selected entity = " +
	// getOWLModelManager().getRendering(selectedEntity);
	// }
	// else {
	// message = "Hello world";
	// }
	// JFrame parent = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class,
	// workspace);
	// JOptionPane.showMessageDialog(parent, message);
	// }

}