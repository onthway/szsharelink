
package com.atlassian.confluence.plugins.szsharelink.szsharelink;

import com.atlassian.confluence.plugins.createcontent.api.contextproviders.AbstractBlueprintContextProvider;
import com.atlassian.confluence.plugins.createcontent.api.contextproviders.BlueprintContext;

/**
 * This provider adds dynamic data for substitution into the content-template's \<at:var> elements.
 */
public class ContentTemplateContextProvider extends AbstractBlueprintContextProvider
{

    @Override
    protected BlueprintContext updateBlueprintContext(BlueprintContext context)
    {
        context.put("variableA", "Hello I am variableA");
        // We're adding a string with HTML tags. It will be correctly rendered because of the "rawXhtml"
        // flag against variableB in the content template.
        context.put("variableB", "<em>Hello I am emphasised variableB</em>");

        return context;
    }
}
