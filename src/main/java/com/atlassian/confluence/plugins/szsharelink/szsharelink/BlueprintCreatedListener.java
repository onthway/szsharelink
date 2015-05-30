

package com.atlassian.confluence.plugins.szsharelink.szsharelink;

import com.atlassian.confluence.plugins.createcontent.api.events.BlueprintPageCreateEvent;
import com.atlassian.event.api.EventListener;
import com.atlassian.event.api.EventPublisher;
import com.atlassian.plugin.ModuleCompleteKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;

/**
* This listener simply logs when a Blueprint is created.
*/
public class BlueprintCreatedListener implements DisposableBean
{
    private static final Logger log = LoggerFactory.getLogger(BlueprintCreatedListener.class);

    private final EventPublisher eventPublisher;

    public BlueprintCreatedListener(EventPublisher eventPublisher)
    {
        this.eventPublisher = eventPublisher;
        eventPublisher.register(this);
    }

    @EventListener
    public void onPageCreateEvent(BlueprintPageCreateEvent event)
    {
        // Ignore Blueprints created by other plugins
        ModuleCompleteKey blueprintKey = event.getBlueprintKey();
        if (!blueprintKey.getPluginKey().equals("com.atlassian.confluence.plugins.szsharelink.szsharelink"))
            return;

        log.warn("Page created with title : " + event.getPage().getTitle());
        log.warn("-- by our Blueprint with key: " + blueprintKey.getModuleKey());
        log.warn("-- by user: " + event.getCreator().getName());
        log.warn("-- from class: " + event.getSource().getClass());
        log.warn("-- with context size: " + event.getContext().size());
    }

    @Override
    public void destroy() throws Exception
    {
        eventPublisher.unregister(this);
    }
}
