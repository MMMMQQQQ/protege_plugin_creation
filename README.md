This is the project which shows us how to create the new plugin in Protege:

1) "Plugin.xml" are mandatory which have been defined the plugins that we want to create.
In this project, there are two types of plugins, one is for the tab, which will have "point="org.protege.editor.core.application.WorkspaceTab"" as the typical symbol, without this declaration, the tab will not be created; another is for the view, correspondingly, it will have "point="org.protege.editor.core.application.ViewComponent"" as the typical symbol.


2) And then we define the java file in which we will define the what will those plugins look like.
 For the java file for the tab plugin, it will extend "OWLWorkspaceViewsTab";
For the java file for the view plugin, it will extend "AbstractOWLViewComponent".

