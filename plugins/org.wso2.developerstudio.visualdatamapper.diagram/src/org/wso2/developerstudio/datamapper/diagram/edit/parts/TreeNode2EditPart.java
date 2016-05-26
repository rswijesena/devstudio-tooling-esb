package org.wso2.developerstudio.datamapper.diagram.edit.parts;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.eclipse.draw2d.Clickable;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.ImageFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.MouseEvent;
import org.eclipse.draw2d.MouseListener;
import org.eclipse.draw2d.MouseMotionListener;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderedShapeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.BorderItemSelectionEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.edit.policies.reparent.CreationEditPolicyWithCustomReparent;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.wso2.developerstudio.datamapper.PropertyKeyValuePair;
import org.wso2.developerstudio.datamapper.TreeNode;
import org.wso2.developerstudio.datamapper.diagram.custom.util.AbsoluteBorderedItemLocator;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.custom.CustomNonResizableEditPolicyEx;
import org.wso2.developerstudio.datamapper.diagram.part.DataMapperVisualIDRegistry;

/**
 * @generated
 */
public class TreeNode2EditPart extends AbstractBorderedShapeEditPart {

	/**
	 * @generated NOT
	 */
	List<IFigure> childrenIFigure;

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 3003;

	/**
	 * @generated
	 */
	protected IFigure contentPane;

	/**
	 * @generated
	 */
	protected IFigure primaryShape;

	/**
	 * @generated NOT
	 */
	boolean isActivated = false;
	public static final String JSON_SCHEMA_TYPE = "type";
	public static final String JSON_SCHEMA_ARRAY = "array";
	public static final String JSON_SCHEMA_OBJECT = "object";
	private static final String JSON_SCHEMA_ARRAY_ITEMS_VALUE_TYPE = "items_value_type";
	private static final String JSON_SCHEMA_OBJECT_VALUE_TYPE = "object_value_type";
	private static final String JSON_SCHEMA_ARRAY_ITEMS_TYPE = "items_type";
	private static final String NULL_VALUE = "null";

	/**
	 * @generated
	 */
	public TreeNode2EditPart(View view) {
		super(view);
	}

	protected void addChild(EditPart child, int index) {
		super.addChild(child, index);
	}

	/**
	 * @generated NOT
	 */
	@Override
	public void activate() {
		super.activate();
		if (!isActivated) {
			List<IFigure> figures = new ArrayList<IFigure>();
			childrenIFigure = new ArrayList<IFigure>();
			int count = getPrimaryShape().getChildren().size();

			for (int i = 0; i < count; i++) {
				IFigure figure = (IFigure) getPrimaryShape().getChildren().get(0);
				figures.add(figure);
				childrenIFigure.add(figure);
				getPrimaryShape().getChildren().remove(figure);
			}
			for (int i = 0; i < count; i++) {
				getPrimaryShape().getChildren().add(figures.get(i));
			}
			((Figure) (getPrimaryShape().getChildren().get(0))).setPreferredSize(100, 20);
			childrenIFigure.remove(childrenIFigure.size() - 1);
			isActivated = true;
		}

	}

	/**
	 * @generated NOT
	 */
	protected void createDefaultEditPolicies() {
		installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationEditPolicyWithCustomReparent(
				org.wso2.developerstudio.datamapper.diagram.part.DataMapperVisualIDRegistry.TYPED_INSTANCE));
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new org.wso2.developerstudio.datamapper.diagram.edit.policies.TreeNode2ItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE,
				new org.wso2.developerstudio.datamapper.diagram.edit.policies.TreeNode2CanonicalEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);

		/* Disable dragging and resizing */
		NonResizableEditPolicy selectionPolicy = new CustomNonResizableEditPolicyEx();
		selectionPolicy.setDragAllowed(false);
		installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE, selectionPolicy);

		/* remove balloon */
		removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.POPUPBAR_ROLE);
	}

	/**
	 * @generated NOT
	 */
	protected LayoutEditPolicy createLayoutEditPolicy() {
		org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy lep = new org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy() {
			protected EditPolicy createChildEditPolicy(EditPart child) {
				View childView = (View) child.getModel();
				switch (org.wso2.developerstudio.datamapper.diagram.part.DataMapperVisualIDRegistry
						.getVisualID(childView)) {
				case org.wso2.developerstudio.datamapper.diagram.edit.parts.InNode3EditPart.VISUAL_ID:
				case org.wso2.developerstudio.datamapper.diagram.edit.parts.OutNode2EditPart.VISUAL_ID:
					return new BorderItemSelectionEditPolicy();
				}
				EditPolicy result = child.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
				if (result == null) {
					result = new NonResizableEditPolicy();
				}
				return result;
			}

			protected Command getMoveChildrenCommand(Request request) {
				return null;
			}

			protected Command getCreateCommand(CreateRequest request) {
				return null;
			}
		};
		return lep;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart#
	 * isSelectable()
	 * 
	 */
	@Override
	public boolean isSelectable() {
		return true;
	}

	/**
	 * @generated NOT
	 */
	protected IFigure createNodeShape() {
		return primaryShape = new TreeNodeFigure();
	}

	/**
	 * @generated
	 */
	public TreeNodeFigure getPrimaryShape() {
		return (TreeNodeFigure) primaryShape;
	}

	private EditPart getParentBox() {
		EditPart temp = this.getParent();
		while ((!(temp instanceof DataMapperRootEditPart)) && (temp != null)) {

			if (temp instanceof InputEditPart || temp instanceof OutputEditPart) {
				break;
			}
			temp = temp.getParent();
		}
		return temp;
	}

	/**
	 * @generated NOT
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		String type = getNodeType();
		EditPart temp = getParentBox();
		if (childEditPart instanceof TreeNodeName2EditPart) {
			((TreeNodeName2EditPart) childEditPart).setLabel(getPrimaryShape().getFigureTreeNodeNameFigure());
			return true;
		}

		if (childEditPart instanceof InNodeEditPart) {
			if (temp instanceof InputEditPart) {
				createEmptyInNode(childEditPart);
			} else {
				// If an element has children, then disable the innode connector
				// arrow
				if (((TreeNode) ((View) getModel()).getElement()).getNode().size() > 0) {
					String value = getNodeValue(type);
					// If an element has values then enable the connector arrow
					if (StringUtils.isNotEmpty(value)) {
						return createInNode(childEditPart);
					}else {
						createEmptyInNode(childEditPart);
					}
				} else {
					if (type.equals(JSON_SCHEMA_OBJECT) || type.equals(JSON_SCHEMA_ARRAY)) {
						String itemsType = getItemsType();
						// If an element has values then enable the connector
						// arrow
						if (itemsType.equals(NULL_VALUE)) {
							createEmptyInNode(childEditPart);				
						} else {
							return createInNode(childEditPart);
						}
					} else {
						if (type.equals(NULL_VALUE)) {
							// If type is null, then disable the in node
							// connector
							createEmptyInNode(childEditPart);
						} else if(StringUtils.isEmpty(type)) {
							createEmptyInNode(childEditPart);
						} else {
							return createInNode(childEditPart);
						}
					}
				}
			}
		}
		if (childEditPart instanceof OutNodeEditPart) {
			if (temp instanceof OutputEditPart) {
				createEmptyOutNode(childEditPart);
			} else {
				// If an element has children, then disable the outnode
				// connector arrow
				if (((TreeNode) ((View) getModel()).getElement()).getNode().size() > 0) {
					String value = getNodeValue(type);
					// If an element has values then enable the connector arrow
					if (StringUtils.isNotEmpty(value)) {
						return createOutNode(childEditPart);
					}else {
						createEmptyOutNode(childEditPart);
					}
				} else {
					if (type.equals(JSON_SCHEMA_OBJECT) || type.equals(JSON_SCHEMA_ARRAY)) {
						String itemsType = getItemsType();
						// If an element has values then enable the connector
						// arrow
						if (itemsType.equals(NULL_VALUE)) {
							createEmptyOutNode(childEditPart);
						} else if(StringUtils.isEmpty(type)) {
							createEmptyOutNode(childEditPart);
						} else {
							return createOutNode(childEditPart);
						}
					} else {
						if (type.equals(NULL_VALUE)) {
							// If type is null, then disable the out node
							// connector
							createEmptyOutNode(childEditPart);
						} else {
							return createOutNode(childEditPart);
						}
					}
				}
			}

		}
		return false;
	}

	public String getNodeType() {
		String type = "";
		for (PropertyKeyValuePair keyValue : (((TreeNode) ((View) getModel()).getElement()).getProperties())) {
			if (keyValue.getKey().equals(JSON_SCHEMA_TYPE)) {
				type = keyValue.getValue();
				break;
			}
		}
		return type;
	}

	public String getNodeValue(String type) {
		String value = "";
		if (type.equals(JSON_SCHEMA_ARRAY)) {
			for (PropertyKeyValuePair keyValue : (((TreeNode) ((View) getModel()).getElement()).getProperties())) {
				if (keyValue.getKey().equals(JSON_SCHEMA_ARRAY_ITEMS_VALUE_TYPE)) {
					value = keyValue.getValue();
					break;
				}
			}
		} else if (type.equals(JSON_SCHEMA_OBJECT)) {
			for (PropertyKeyValuePair keyValue : (((TreeNode) ((View) getModel()).getElement()).getProperties())) {
				if (keyValue.getKey().equals(JSON_SCHEMA_OBJECT_VALUE_TYPE)) {
					value = keyValue.getValue();
					break;
				}
			}
		}

		return value;
	}
	
	public String getItemsType(){
		String type = "";
		for (PropertyKeyValuePair keyValue : (((TreeNode) ((View) getModel()).getElement()).getProperties())) {
			if (keyValue.getKey().equals(JSON_SCHEMA_ARRAY_ITEMS_TYPE)) {
				type = keyValue.getValue();
				break;
			}
		}
		return type;
	}

	public void getParentNodeChildren() {
		// check if it has children, if so return the children node list
	}

	/*
	 * private void removeChildNode(EditPart childEditPart) { TreeNode2EditPart
	 * treenode = (TreeNode2EditPart) childEditPart.getParent();
	 * treenode.removeChild(childEditPart); }
	 */

	private boolean createOutNode(EditPart childEditPart) {
		IFigure borderItemFigure = ((OutNodeEditPart) childEditPart).getFigure();
		BorderItemLocator locator = new AbsoluteBorderedItemLocator(getMainFigure(), borderItemFigure,
				PositionConstants.EAST, 4);
		getBorderedFigure().getBorderItemContainer().add(((OutNodeEditPart) childEditPart).getFigure(), locator);
		return true;
	}

	private void createEmptyOutNode(EditPart childEditPart) {
		NodeFigure figureInput = (NodeFigure) ((OutNodeEditPart) childEditPart).getFigure();
		figureInput.removeAll();
		Figure emptyFigure = new Figure();
		figureInput.add(emptyFigure);
	}

	private boolean createInNode(EditPart childEditPart) {
		IFigure borderItemFigure = ((InNodeEditPart) childEditPart).getFigure();
		BorderItemLocator locator = new AbsoluteBorderedItemLocator(getMainFigure(), borderItemFigure,
				PositionConstants.WEST, 4);
		getBorderedFigure().getBorderItemContainer().add(((InNodeEditPart) childEditPart).getFigure(), locator);
		return true;
	}

	private void createEmptyInNode(EditPart childEditPart) {
		NodeFigure figureInput = (NodeFigure) ((InNodeEditPart) childEditPart).getFigure();
		figureInput.removeAll();
		Figure emptyFigure = new Figure();
		figureInput.add(emptyFigure);
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof TreeNodeName2EditPart) {
			return true;
		}
		if (childEditPart instanceof InNodeEditPart) {
			getBorderedFigure().getBorderItemContainer().remove(((InNodeEditPart) childEditPart).getFigure());
			return true;
		}
		if (childEditPart instanceof OutNodeEditPart) {
			getBorderedFigure().getBorderItemContainer().remove(((OutNodeEditPart) childEditPart).getFigure());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected void addChildVisual(EditPart childEditPart, int index) {
		if (addFixedChild(childEditPart)) {
			return;
		}
		super.addChildVisual(childEditPart, -1);
	}

	/**
	 * @generated
	 */
	protected void removeChildVisual(EditPart childEditPart) {
		if (removeFixedChild(childEditPart)) {
			return;
		}
		super.removeChildVisual(childEditPart);
	}

	/**
	 * @generated
	 */
	protected IFigure getContentPaneFor(IGraphicalEditPart editPart) {
		if (editPart instanceof IBorderItemEditPart) {
			return getBorderedFigure().getBorderItemContainer();
		}
		return getContentPane();
	}

	/**
	 * @generated NOT
	 */
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(10, 10);
		return result;
	}

	/**
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model so
	 * you may safely remove <i>generated</i> tag and modify it.
	 * 
	 * @generated
	 */
	protected NodeFigure createMainFigure() {
		NodeFigure figure = createNodePlate();
		figure.setLayoutManager(new StackLayout());
		IFigure shape = createNodeShape();
		figure.add(shape);
		contentPane = setupContentPane(shape);
		return figure;
	}

	/**
	 * Default implementation treats passed figure as content pane. Respects
	 * layout one may have set for generated figure.
	 * 
	 * @param nodeShape
	 *            instance of generated figure class
	 * @generated
	 */
	protected IFigure setupContentPane(IFigure nodeShape) {
		if (nodeShape.getLayoutManager() == null) {
			ConstrainedToolbarLayout layout = new ConstrainedToolbarLayout();
			layout.setSpacing(5);
			nodeShape.setLayoutManager(layout);
		}
		return nodeShape; // use nodeShape itself as contentPane
	}

	/**
	 * @generated
	 */
	public IFigure getContentPane() {
		if (contentPane != null) {
			return contentPane;
		}
		return super.getContentPane();
	}

	/**
	 * @generated
	 */
	protected void setForegroundColor(Color color) {
		if (primaryShape != null) {
			primaryShape.setForegroundColor(color);
		}
	}

	/**
	 * @generated
	 */
	protected void setBackgroundColor(Color color) {
		if (primaryShape != null) {
			primaryShape.setBackgroundColor(color);
		}
	}

	/**
	 * @generated
	 */
	protected void setLineWidth(int width) {
		if (primaryShape instanceof Shape) {
			((Shape) primaryShape).setLineWidth(width);
		}
	}

	/**
	 * @generated
	 */
	protected void setLineType(int style) {
		if (primaryShape instanceof Shape) {
			((Shape) primaryShape).setLineStyle(style);
		}
	}

	/**
	 * @generated
	 */
	public EditPart getPrimaryChildEditPart() {
		return getChildBySemanticHint(DataMapperVisualIDRegistry.getType(TreeNodeName2EditPart.VISUAL_ID));
	}

	/**
	 * @generated NOT
	 */
	public class TreeNodeFigure extends RectangleFigure {

		private static final String ELEMENT_ICON = "icons/gmf/symbol_element_of.gif";
		private static final String ATTRIBUTE_ICON = "icons/gmf/AttributeIcon.png";
		private static final String ARRAY_ICON = "icons/gmf/arrays.jpg";
		private static final String OBJECT_ICON = "icons/gmf/object.jpg";
		private static final String ORG_WSO2_DEVELOPERSTUDIO_VISUALDATAMAPPER_DIAGRAM = "org.wso2.developerstudio.visualdatamapper.diagram";
		private static final String JSON_SCHEMA_TYPE = "type";
		private static final String JSON_SCHEMA_ARRAY = "array";
		private static final String JSON_SCHEMA_OBJECT = "object";

		private static final String PREFIX = "@";
		/**
		 * @generated
		 */
		private WrappingLabel fFigureTreeNodeNameFigure;

		/**
		 * @generated NOT
		 */
		boolean isExpanded = true;

		/**
		 * @generated NOT
		 */
		ClickNode clickNode;

		/**
		 * @generated NOT
		 */
		public TreeNodeFigure() {

			ToolbarLayout layoutThis = new ToolbarLayout();
			layoutThis.setStretchMinorAxis(true);
			layoutThis.setMinorAlignment(ToolbarLayout.ALIGN_TOPLEFT);
			// layoutThis.setSpacing(1);
			layoutThis.setVertical(true);
			this.setLayoutManager(layoutThis);
			this.setOpaque(false);
			this.setFill(false);
			this.setOutline(false);
			createContents();

		}

		/**
		 * @generated NOT
		 */
		private void createContents() {

			RectangleFigure figure = new RectangleFigure();
			ToolbarLayout l = new ToolbarLayout();
			l.setVertical(false);
			figure.setLayoutManager(l);
			figure.setPreferredSize(100, 3);

			figure.setBorder(null);
			figure.setOpaque(false);

			RectangleFigure figure2 = new RectangleFigure();
			figure2.setBorder(null);
			figure2.setOpaque(false);

			ImageDescriptor mainImgDescCollapse = AbstractUIPlugin
					.imageDescriptorFromPlugin(ORG_WSO2_DEVELOPERSTUDIO_VISUALDATAMAPPER_DIAGRAM, ELEMENT_ICON);// plus

			ImageDescriptor attributeImgDesc = AbstractUIPlugin
					.imageDescriptorFromPlugin(ORG_WSO2_DEVELOPERSTUDIO_VISUALDATAMAPPER_DIAGRAM, ATTRIBUTE_ICON);

			ImageDescriptor arrayImgDesc = AbstractUIPlugin
					.imageDescriptorFromPlugin(ORG_WSO2_DEVELOPERSTUDIO_VISUALDATAMAPPER_DIAGRAM, ARRAY_ICON);

			ImageDescriptor objectImgDesc = AbstractUIPlugin
					.imageDescriptorFromPlugin(ORG_WSO2_DEVELOPERSTUDIO_VISUALDATAMAPPER_DIAGRAM, OBJECT_ICON);

			final ImageFigure mainImg = new ImageFigure(mainImgDescCollapse.createImage());
			mainImg.setSize(new Dimension(10, 8));
			ImageFigure attributeImg = new ImageFigure(attributeImgDesc.createImage()); // attribute
																						// symbole
																						// figure
			attributeImg.setSize(new Dimension(10, 8));
			ImageFigure arrayImg = new ImageFigure(arrayImgDesc.createImage()); // array
																				// symbole
																				// figure
			arrayImg.setSize(new Dimension(10, 8));
			ImageFigure objectImg = new ImageFigure(objectImgDesc.createImage()); // object
																					// symbole
																					// figure
			arrayImg.setSize(new Dimension(10, 8));

			RectangleFigure mainImageRectangle = new RectangleFigure();

			mainImageRectangle.setBackgroundColor(new Color(null, 255, 255, 255));
			mainImageRectangle.setPreferredSize(new Dimension(10, 7));
			mainImageRectangle.add(mainImg);
			mainImageRectangle.setBorder(new MarginBorder(1, 1, 1, 1));

			RectangleFigure attributeImageRectangle = new RectangleFigure();

			attributeImageRectangle.setBackgroundColor(new Color(null, 255, 255, 255));
			attributeImageRectangle.setPreferredSize(new Dimension(10, 7));
			attributeImageRectangle.add(attributeImg);
			mainImageRectangle.setBorder(new MarginBorder(1, 1, 1, 1));

			RectangleFigure arrayImageRectangle = new RectangleFigure();

			arrayImageRectangle.setBackgroundColor(new Color(null, 255, 255, 255));
			arrayImageRectangle.setPreferredSize(new Dimension(10, 7));
			arrayImageRectangle.add(attributeImg);
			arrayImageRectangle.setBorder(new MarginBorder(1, 1, 1, 1));

			RectangleFigure objectImageRectangle = new RectangleFigure();

			objectImageRectangle.setBackgroundColor(new Color(null, 255, 255, 255));
			objectImageRectangle.setPreferredSize(new Dimension(10, 7));
			objectImageRectangle.add(attributeImg);
			objectImageRectangle.setBorder(new MarginBorder(1, 1, 1, 1));

			fFigureTreeNodeNameFigure = new WrappingLabel();

			/*
			 * String name = (((TreeNode) ((View)
			 * getModel()).getElement()).getName()).split(",")[1]; int count =
			 * Integer.parseInt((((TreeNode) ((View)
			 * getModel()).getElement()).getName()) .split(",")[0]);
			 */
			String name = (((TreeNode) ((View) getModel()).getElement()).getName());
			String type = null;
			for (PropertyKeyValuePair keyValue : (((TreeNode) ((View) getModel()).getElement()).getProperties())) {
				if (keyValue.getKey().equals(JSON_SCHEMA_TYPE)) {
					type = keyValue.getValue();
					break;
				}
			}

			int count = ((TreeNode) ((View) getModel()).getElement()).getLevel();
			fFigureTreeNodeNameFigure.setText(name);
			fFigureTreeNodeNameFigure.setForegroundColor(ColorConstants.black);
			fFigureTreeNodeNameFigure.setFont(new Font(null, "Arial", 10, SWT.BOLD));

			String newName = null;
			if (StringUtils.isNotEmpty(name) && name.startsWith(PREFIX)) {
				String[] fullName = name.split(PREFIX);
				newName = fullName[1];
			} else {
				newName = name;
			}
			figure2.setPreferredSize((count - 1) * 22, 3);
			Label nodeLabel = new Label();
			if (StringUtils.isNotEmpty(name) && name.startsWith(PREFIX)) {
				nodeLabel.setIcon(attributeImg.getImage());
			} else if (type != null && type.equals(JSON_SCHEMA_ARRAY)) {
				nodeLabel.setIcon(arrayImg.getImage());
			} else if (type != null && type.equals(JSON_SCHEMA_OBJECT)) {
				nodeLabel.setIcon(objectImg.getImage());
			} else {
				nodeLabel.setIcon(mainImg.getImage());
			}
			Display display = Display.getCurrent();
			Color black = display.getSystemColor(SWT.COLOR_BLACK);
			nodeLabel.setForegroundColor(black);
			nodeLabel.setText(newName);
			nodeLabel.setSize(new Dimension(100, 5));

			this.addMouseMotionListener(new MouseMotionListener() {

				@Override
				public void mouseDragged(MouseEvent me) {
					highlightElementOnSelection();

				}

				@Override
				public void mouseEntered(MouseEvent me) {
					highlightElementOnSelection();
					getEditDomain().getPaletteViewer().setActiveTool((ToolEntry) (((PaletteContainer) getEditDomain()
							.getPaletteViewer().getPaletteRoot().getChildren().get(1)).getChildren().get(0)));

				}

				@Override
				public void mouseExited(MouseEvent me) {
					removeHighlight();
					getEditDomain().getPaletteViewer().setActiveTool(null);

				}

				@Override
				public void mouseHover(MouseEvent me) {
					highlightElementOnSelection();

				}

				@Override
				public void mouseMoved(MouseEvent me) {
				}

			});
			this.addMouseListener(new MouseListener() {

				@Override
				public void mouseReleased(MouseEvent me) {
					removeHighlight();

				}

				@Override
				public void mousePressed(MouseEvent me) {
					highlightElementOnSelection();

				}

				@Override
				public void mouseDoubleClicked(MouseEvent me) {
					highlightElementOnSelection();

				}
			});

			figure.setOutline(false);
			figure2.setOutline(false);
			figure.add(figure2);
			figure.add(nodeLabel);
			figure.setFill(false);
			figure2.setFill(false);
			this.setFill(false);
			this.setOutline(false);

			this.add(figure);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureTreeNodeNameFigure() {
			return fFigureTreeNodeNameFigure;
		}

		/**
		 * @generated NOT
		 */
		public void repaint(boolean Expanded, ImageFigure image) {
			if (!Expanded) {
				clickNode.setContents(image);
				isExpanded = true;
				for (int i = childrenIFigure.size() - 1; i >= 0; i--) {
					getPrimaryShape().getChildren().add(childrenIFigure.get(i));
				}
			} else {
				clickNode.setContents(image);
				isExpanded = false;

				for (int i = 0; i < childrenIFigure.size(); i++) {
					getPrimaryShape().getChildren().remove(childrenIFigure.get(i));
				}
			}
		}

		/**
		 * @generated NOT
		 */
		public class ClickNode extends Clickable {
			public ClickNode(ImageFigure image) {
				this.setContents(image);
			}

			@Override
			protected void setContents(IFigure contents) {
				super.setContents(contents);
			}
		}

		public void renameElement(String name, String type) {

			ImageDescriptor mainImgDescCollapse = AbstractUIPlugin
					.imageDescriptorFromPlugin(ORG_WSO2_DEVELOPERSTUDIO_VISUALDATAMAPPER_DIAGRAM, ELEMENT_ICON);
			ImageDescriptor attributeImgDesc = AbstractUIPlugin
					.imageDescriptorFromPlugin(ORG_WSO2_DEVELOPERSTUDIO_VISUALDATAMAPPER_DIAGRAM, ATTRIBUTE_ICON);
			ImageDescriptor arrayImgDesc = AbstractUIPlugin
					.imageDescriptorFromPlugin(ORG_WSO2_DEVELOPERSTUDIO_VISUALDATAMAPPER_DIAGRAM, ARRAY_ICON);
			ImageDescriptor objectImgDesc = AbstractUIPlugin
					.imageDescriptorFromPlugin(ORG_WSO2_DEVELOPERSTUDIO_VISUALDATAMAPPER_DIAGRAM, OBJECT_ICON);

			final ImageFigure mainImg = new ImageFigure(mainImgDescCollapse.createImage());
			mainImg.setSize(new Dimension(10, 8));

			ImageFigure attributeImg = new ImageFigure(attributeImgDesc.createImage()); // attribute
																						// symbole
																						// figure
			attributeImg.setSize(new Dimension(10, 8));

			ImageFigure arrayImg = new ImageFigure(arrayImgDesc.createImage()); // array
																				// symbole
																				// figure
			attributeImg.setSize(new Dimension(10, 8));

			ImageFigure objectImg = new ImageFigure(objectImgDesc.createImage()); // object
																					// symbole
																					// figure
			attributeImg.setSize(new Dimension(10, 8));

			Label nodeLabel = new Label();

			String newName = null;
			if (StringUtils.isNotEmpty(name) && name.startsWith(PREFIX)) {
				String[] fullName = name.split(PREFIX);
				newName = fullName[1];
			} else {
				newName = name;
			}
			if (StringUtils.isNotEmpty(name) && name.startsWith(PREFIX)) {
				nodeLabel.setIcon(attributeImg.getImage());
			} else if (type != null && type.equals(JSON_SCHEMA_ARRAY)) {
				nodeLabel.setIcon(arrayImg.getImage());
			} else if (type != null && type.equals(JSON_SCHEMA_OBJECT)) {
				nodeLabel.setIcon(objectImg.getImage());
			} else {
				nodeLabel.setIcon(mainImg.getImage());
			}

			Display display = Display.getCurrent();
			Color black = display.getSystemColor(SWT.COLOR_BLACK);
			nodeLabel.setForegroundColor(black);
			nodeLabel.setText(newName);
			nodeLabel.setSize(new Dimension(100, 5));
			RectangleFigure rectFigure = (RectangleFigure) this.getChildren().get(0);
			List<Figure> childrenList = rectFigure.getChildren();
			rectFigure.remove(childrenList.get(1));
			rectFigure.add(nodeLabel);

		}

		public void highlightElementOnSelection() {
			RectangleFigure rectFigure = (RectangleFigure) this.getChildren().get(0);
			List<Figure> childrenList = rectFigure.getChildren();
			Display display = Display.getCurrent();
			Color bckGrndColor = new Color(null, 0, 125, 133);
			Label newLabel = (Label) childrenList.get(1);
			newLabel.setForegroundColor(bckGrndColor);
			rectFigure.remove(childrenList.get(1));
			rectFigure.add(newLabel);
		}

		public void removeHighlight() {
			RectangleFigure rectFigure = (RectangleFigure) this.getChildren().get(0);
			List<Figure> childrenList = rectFigure.getChildren();
			Display display = Display.getCurrent();
			Color bckGrndColor = display.getSystemColor(SWT.COLOR_BLACK);
			Label newLabel = (Label) childrenList.get(1);
			newLabel.setForegroundColor(bckGrndColor);
			rectFigure.remove(childrenList.get(1));
			rectFigure.add(newLabel);
		}
	}

	public void renameElementItem(String newName, String type) {
		getPrimaryShape().renameElement(newName, type);
	}

	public void removeHighlightOnElem() {
		getPrimaryShape().removeHighlight();
	}

	public void highlightElementItem() {
		getPrimaryShape().highlightElementOnSelection();
	}

}
