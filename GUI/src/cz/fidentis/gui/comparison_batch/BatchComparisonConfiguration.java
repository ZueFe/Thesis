/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.fidentis.gui.comparison_batch;

import cz.fidentis.comparison.ComparisonMethod;
import cz.fidentis.comparison.RegistrationMethod;
import cz.fidentis.comparison.procrustes.ProcrustesBatchProcessing;
import cz.fidentis.controller.BatchComparison;
import cz.fidentis.featurepoints.FacialPoint;
import cz.fidentis.gui.GUIController;
import cz.fidentis.gui.ProjectTopComponent;
import cz.fidentis.gui.guisetup.BatchGUIsetup;
import cz.fidentis.model.Model;
import cz.fidentis.model.ModelLoader;
import cz.fidentis.processing.comparison.surfaceComparison.SurfaceComparisonProcessing;
import cz.fidentis.processing.exportProcessing.FPImportExport;
import cz.fidentis.processing.exportProcessing.ResultExports;
import cz.fidentis.utils.SortUtils;
import cz.fidentis.utilsException.FileManipulationException;
import cz.fidentis.visualisation.procrustes.PApainting;
import cz.fidentis.visualisation.procrustes.PApaintingInfo;
import java.awt.Color;
import java.io.File;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.netbeans.api.progress.ProgressHandle;
import org.netbeans.api.progress.ProgressHandleFactory;
import org.openide.util.Exceptions;
import cz.fidentis.visualisation.surfaceComparison.HDpainting;
import cz.fidentis.visualisation.surfaceComparison.HDpaintingInfo;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Katka
 */
@SuppressWarnings("rawtypes")
public class BatchComparisonConfiguration extends javax.swing.JPanel {

    JPanel activeColorPanel;

    /**
     * Creates new form ComparisonConfiguration
     */
    public BatchComparisonConfiguration() {
        initComponents();
        activeColorPanel = new JPanel();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jFileChooser1 = new javax.swing.JFileChooser();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        jLabel3 = new javax.swing.JLabel();
        comparisonComboBox = new javax.swing.JComboBox();
        jPanel4 = new javax.swing.JPanel();
        procrustesPanel = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        fpScaleCheckBox = new javax.swing.JCheckBox();
        jLabel12 = new javax.swing.JLabel();
        fpThresholdSlider = new javax.swing.JSlider();
        processComparisonButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jButton2 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        exportLandmarksButton = new javax.swing.JButton();

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, org.openide.util.NbBundle.getMessage(BatchComparisonConfiguration.class, "BatchComparisonConfiguration.jLabel2.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel3, org.openide.util.NbBundle.getMessage(BatchComparisonConfiguration.class, "BatchComparisonConfiguration.jLabel3.text")); // NOI18N

        comparisonComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Hausdorff Distance", "Procrustes Analysis" }));
        comparisonComboBox.setMinimumSize(new java.awt.Dimension(182, 20));
        comparisonComboBox.setPreferredSize(new java.awt.Dimension(182, 20));
        comparisonComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comparisonComboBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        procrustesPanel.setVisible(false);

        org.openide.awt.Mnemonics.setLocalizedText(jLabel8, org.openide.util.NbBundle.getMessage(BatchComparisonConfiguration.class, "BatchComparisonConfiguration.jLabel8.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(fpScaleCheckBox, org.openide.util.NbBundle.getMessage(BatchComparisonConfiguration.class, "BatchComparisonConfiguration.fpScaleCheckBox.text")); // NOI18N
        fpScaleCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fpScaleCheckBoxActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel12, org.openide.util.NbBundle.getMessage(BatchComparisonConfiguration.class, "BatchComparisonConfiguration.jLabel12.text")); // NOI18N

        fpThresholdSlider.setMajorTickSpacing(20);
        fpThresholdSlider.setMinorTickSpacing(5);
        fpThresholdSlider.setPaintLabels(true);
        fpThresholdSlider.setPaintTicks(true);
        fpThresholdSlider.setSnapToTicks(true);
        fpThresholdSlider.setValue(30);
        fpThresholdSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                fpThresholdSliderStateChanged(evt);
            }
        });

        javax.swing.GroupLayout procrustesPanelLayout = new javax.swing.GroupLayout(procrustesPanel);
        procrustesPanel.setLayout(procrustesPanelLayout);
        procrustesPanelLayout.setHorizontalGroup(
            procrustesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(procrustesPanelLayout.createSequentialGroup()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(fpThresholdSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
            .addGroup(procrustesPanelLayout.createSequentialGroup()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fpScaleCheckBox)
                .addContainerGap(159, Short.MAX_VALUE))
        );
        procrustesPanelLayout.setVerticalGroup(
            procrustesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(procrustesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(procrustesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fpScaleCheckBox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(procrustesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fpThresholdSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        Hashtable tresholdTable = new Hashtable();
        tresholdTable.put(new Integer(0), new JLabel("0"));
        tresholdTable.put(new Integer(20), new JLabel("0,2"));
        tresholdTable.put(new Integer(40), new JLabel("0,4"));
        tresholdTable.put(new Integer(60), new JLabel("0,6"));
        tresholdTable.put(new Integer(80), new JLabel("0,8"));
        tresholdTable.put(new Integer(100), new JLabel("1"));
        fpThresholdSlider.setLabelTable(tresholdTable);

        org.openide.awt.Mnemonics.setLocalizedText(processComparisonButton, org.openide.util.NbBundle.getMessage(BatchComparisonConfiguration.class, "BatchComparisonConfiguration.processComparisonButton.text")); // NOI18N
        processComparisonButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processComparisonButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jButton1, org.openide.util.NbBundle.getMessage(BatchComparisonConfiguration.class, "BatchComparisonConfiguration.jButton1.text")); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jButton2, org.openide.util.NbBundle.getMessage(BatchComparisonConfiguration.class, "BatchComparisonConfiguration.jButton2.text")); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jButton10, org.openide.util.NbBundle.getMessage(BatchComparisonConfiguration.class, "BatchComparisonConfiguration.jButton10.text")); // NOI18N
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(exportLandmarksButton, org.openide.util.NbBundle.getMessage(BatchComparisonConfiguration.class, "BatchComparisonConfiguration.exportLandmarksButton.text")); // NOI18N
        exportLandmarksButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportLandmarksButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(procrustesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comparisonComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2)
                    .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(281, 281, 281)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(exportLandmarksButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(processComparisonButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel2)
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(comparisonComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(procrustesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(processComparisonButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(exportLandmarksButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(82, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );
    }// </editor-fold>//GEN-END:initComponents

    public void computeComparison(final ProjectTopComponent tc) {
        final BatchComparison c = getContext();
        
        Runnable run;
        run = new Runnable() {

            @Override
            public void run() {
                
                processComparisonButton.setEnabled(false);
                c.setCompareButtonEnabled(false);
                ProgressHandle p;

                p = ProgressHandleFactory.createHandle("Computing comparison...");

                try {
                    GUIController.setPauseButtonVisible(true);
                    p.start();
                    
                    ComparisonMethod compM = c.getComparisonMethod();

                    //Computing Hausdorff Distance
                    if (compM == ComparisonMethod.HAUSDORFF_DIST
                            || compM == ComparisonMethod.HAUSDORFF_CURV) {
                        p.setDisplayName("Computing comparison...");
                        SurfaceComparisonProcessing.setP(p);

                        ArrayList<ArrayList<Float>> results;
                        ArrayList<ArrayList<Float>> numResults;
                        List<Float> variance;
                        List<File> originalModels = c.getModels();
                        List<File> models = c.getRegistrationResults();
                        if (models == null) {
                            models = originalModels;
                        }
                        Model template = null;
                        
                        //only compute new avg face if models were added
                        if(c.isModelsAdded()){
                            ModelLoader ml = new ModelLoader();
                            template = ml.loadModel(models.get(c.getTemplateIndex()), false, false);
                        }else{
                            template = c.getAverageFace();
                        }
                        

                        tc.getViewerPanel_Batch().getListener().getModels().set(0, template);

                        try {
                            
                                                        
                            //visual results
                            results = SurfaceComparisonProcessing.instance().compareFaces(template, models, true, compM,
                                    c.getIcpMetric(), c.isModelsAdded());
                            c.setHdVisualResults(results);

                           c.setAverageFace(template);
                           c.setModelsAdded(false);

                            variance = SurfaceComparisonProcessing.instance().computeVariation(results, 0, true);

                            c.setHd(variance);


                            HDpaintingInfo info = new HDpaintingInfo(variance, template, true);

                            HDpainting paintMain = new HDpainting(info);

                            tc.getViewerPanel_Batch().getListener().setHdPaint(paintMain);
                            tc.getViewerPanel_Batch().getListener().setHdInfo(info);
                            c.setHDP(paintMain);
                            c.setHDinfo(info);
                            tc.getViewerPanel_Batch().getListener().drawHD(true);

                            //numerical results
                            numResults = SurfaceComparisonProcessing.instance().batchCompareNumericalResults(models, 0, true,
                                    1.0f, 0.0f, compM, c);

                            List<Float> sortedHd = SortUtils.instance().sortValues(variance);

                            c.setNumericalResults(SurfaceComparisonProcessing.instance().batchCompareNumericalResultsTable(numResults, 0, originalModels, 1f, 0f));
                            c.setSortedHd(sortedHd);

                        } catch (FileManipulationException ex) {
                            //osefuj error
                        }

                    } else if (compM == ComparisonMethod.PROCRUSTES) {

                        //Starting procrustes comparison
                        List<List<FacialPoint>> list = new ArrayList();
                        int size = c.getModels().size();
                        for (int i = 0; i < size; i++) {
                            List<FacialPoint> facialPoints = c.getFacialPoints(
                                    c.getModels().get(i).getName());
                            list.add(facialPoints);
                        }

                        //List of points was created
                        ProcrustesBatchProcessing procrustes = new ProcrustesBatchProcessing(list, c.isFpScaling());

                        //String result = procrustes.doBatchProcessing(jSlider3.getValue() / 100f);
                        String result = procrustes.compareBatch(c.getModels());
                        c.setDistanceToMeanConfiguration(procrustes.distanceToMean());

                        //GPA done
                        //GUIController.getConfigurationTopComponent().getBatchComparisonResults().setNumericalResult(result);
                        c.setNumericalResults(result);

                        //GUIController.getSelectedProjectTopComponent().getViewerPanel_Batch().getCanvas1().setDescriptionText(result);
                        tc.getViewerPanel_Batch().getListener().setProcrustes(true);

                        PApaintingInfo paInfo = new PApaintingInfo(procrustes.getGpa(), null, 2);

                        if (c.isFpScaling()) {      //??
                            tc.getViewerPanel_Batch().getListener().setCameraPosition(0, 0, 700);
                            paInfo.setPointSize(30 * 3);

                        } else {
                            tc.getViewerPanel_Batch().getListener().setCameraPosition(0, 0, 700);
                            paInfo.setPointSize(30 * 3);
                        }

                        tc.getViewerPanel_Batch().getListener().setPaInfo(paInfo);
                        tc.getViewerPanel_Batch().getListener().setPaPainting(new PApainting(paInfo));

                        repaint();
                    }

                    processComparisonButton.setEnabled(true);
                    c.setCompareButtonEnabled(true);
                    p.finish();
                    
                    //set up default comparison result data
                    BatchGUIsetup.defaultValuesComparisonResults(c);

                    c.setState(3);

                    if (GUIController.getSelectedProjectTopComponent() == tc) {
                        GUIController.getConfigurationTopComponent().addBatchComparisonResults();
                    }
                    
                    //set up default comparison result data
                    
                    GUIController.setPauseButtonVisible(false);
                    GUIController.updateNavigator();
                } catch (Exception ex) {
                   Exceptions.printStackTrace(ex);
                   processComparisonButton.setEnabled(true);
                }finally{
                    p.finish();
                }
            }

        };
        Thread t = new Thread(run);
        t.start(); // start the task and progress visualisation
    }

    private void processComparisonButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processComparisonButtonActionPerformed
        computeComparison(GUIController.getSelectedProjectTopComponent());
    }//GEN-LAST:event_processComparisonButtonActionPerformed

    private void fpScaleCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fpScaleCheckBoxActionPerformed
        getContext().setFpScaling(fpScaleCheckBox.isSelected());
    }//GEN-LAST:event_fpScaleCheckBoxActionPerformed

    private void comparisonComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comparisonComboBoxActionPerformed
        ComparisonMethod compM = (ComparisonMethod) comparisonComboBox.getSelectedItem();
        
        if (compM == ComparisonMethod.PROCRUSTES) {
            procrustesPanel.setVisible(true);
        }
        if (compM == ComparisonMethod.HAUSDORFF_DIST ||
                compM == ComparisonMethod.HAUSDORFF_CURV) {
            procrustesPanel.setVisible(false);

        }
       
        getContext().setComparisonMethod(compM);
    }//GEN-LAST:event_comparisonComboBoxActionPerformed

    private void fpThresholdSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_fpThresholdSliderStateChanged
        getContext().setFpTreshold(fpThresholdSlider.getValue());
    }//GEN-LAST:event_fpThresholdSliderStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        BatchComparison c = getContext();
        
        //get correct value for selected avg model
        c.setTemplateIndex(c.getTemplateIndex() + 3);
        
        c.setState(1);
        GUIController.getConfigurationTopComponent().addBatchRegistrationComponent();
        ModelLoader ml = new ModelLoader();
        Model m = ml.loadModel(getContext().getModel(0), false, true);
        GUIController.getSelectedProjectTopComponent().getViewerPanel_Batch().setModel(m);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        final ProjectTopComponent tc = GUIController.getSelectedProjectTopComponent();
        ResultExports.instance().saveAvgFace(tc, getContext().getAverageFace(),
                "_batch");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        final ProjectTopComponent tc = GUIController.getSelectedProjectTopComponent();
        ResultExports.instance().saveRegisteredModelsBatch(tc, getContext().getRegistrationResults(),
                getContext().getModels(), "_batch");
    }//GEN-LAST:event_jButton10ActionPerformed

    private void exportLandmarksButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportLandmarksButtonActionPerformed
        final ProjectTopComponent tc = GUIController.getSelectedProjectTopComponent();
        FPImportExport.instance().exportBatch(tc, getContext());
    }//GEN-LAST:event_exportLandmarksButtonActionPerformed

    public Boolean getScaleEnabled() {
        return fpScaleCheckBox.isSelected();
    }

    public void setProcessComparisonEnabled(boolean en) {
        processComparisonButton.setEnabled(en);
        getContext().setCompareButtonEnabled(en);
    }

    private BatchComparison getContext(){
        return GUIController.getSelectedProjectTopComponent().getProject().getSelectedBatchComparison();
    }
    
    public void setConfiguration() {
        BatchComparison c = getContext();
        RegistrationMethod reg = c.getRegistrationMethod();
        
        //because some items might need to be removed based on the mode later
        comparisonComboBox.setModel(new DefaultComboBoxModel(ComparisonMethod.values()));

        
        comparisonComboBox.setSelectedItem(c.getComparisonMethod());
        fpScaleCheckBox.setSelected(c.isFpScaling());
        jButton2.setVisible(reg == RegistrationMethod.HAUSDORFF);
        exportLandmarksButton.setVisible(reg == RegistrationMethod.PROCRUSTES);
        
        procrustesPanel.setVisible(c.getComparisonMethod() == ComparisonMethod.PROCRUSTES);
        
        fpThresholdSlider.setValue(c.getFpTreshold());
        
        if(reg != RegistrationMethod.PROCRUSTES){
           comparisonComboBox.removeItemAt(1);
        }
        
        processComparisonButton.setEnabled(c.isCompareButtonEnabled());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox comparisonComboBox;
    private javax.swing.JButton exportLandmarksButton;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JCheckBox fpScaleCheckBox;
    private javax.swing.JSlider fpThresholdSlider;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton processComparisonButton;
    private javax.swing.JPanel procrustesPanel;
    // End of variables declaration//GEN-END:variables
}
