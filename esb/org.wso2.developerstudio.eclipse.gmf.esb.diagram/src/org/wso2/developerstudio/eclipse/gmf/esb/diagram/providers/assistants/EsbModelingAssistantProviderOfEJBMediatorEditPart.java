package org.wso2.developerstudio.eclipse.gmf.esb.diagram.providers.assistants;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.providers.EsbElementTypes;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.providers.EsbModelingAssistantProvider;

/**
 * @generated
 */
public class EsbModelingAssistantProviderOfEJBMediatorEditPart extends
		EsbModelingAssistantProvider {

	/**
	 * @generated
	 */
	@Override
	public List<IElementType> getTypesForPopupBar(IAdaptable host) {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(EsbElementTypes.EJBMediatorInputConnector_3687);
		types.add(EsbElementTypes.EJBMediatorOutputConnector_3688);
		return types;
	}

}
