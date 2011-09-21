package com.ideastobettertheworld.forms;

import com.ideas.api.client.services.ideas.IdeasService;
import com.ideas.entities.ideas.Idea;
import com.ideastobettertheworld.BaseForm;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.form.AjaxFormSubmitBehavior;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;

/**
 * Form for posting ideas.
 */
public class PostIdeaForm extends BaseForm<Idea>
{

    private Model<Idea> ideaModel;

    private PropertyModel<String> titlePropertyModel;
    private PropertyModel<String> ideaTextPropertyModel;

    private TextField<String> titleTextField;
    private TextArea<String> ideaTextArea;

    private AjaxButton submitButton;

    public PostIdeaForm(String id)
    {
        super(id);
    }

    public PostIdeaForm(String id, IModel<Idea> ideaIModel)
    {
        super(id, ideaIModel);
    }

    /**
     * Setup the form.
     */
    public void setupForm()
    {
        Idea idea = new Idea();
        setIdeaModel(
                new Model<Idea>(idea)
        );

        setTitlePropertyModel(
                new PropertyModel<String>(
                        idea,
                        "title"
                )
        );

        setTitleTextField(
                new TextField<String>(
                        "title",
                        new Model<String>()
                )
        );

        getTitleTextField().setOutputMarkupId(true);

        add(
                getTitleTextField()
        );

        setIdeaTextPropertyModel(
                new PropertyModel<String>(
                        idea,
                        "ideaText"
                )
        );

        setIdeaTextArea(
                new TextArea<String>(
                        "ideaText",
                        new Model<String>()
                )
        );

        getIdeaTextArea().setOutputMarkupId(true);

        add(
                getIdeaTextArea()
        );


        setSubmitButton(new AjaxButton("shareButton"){
            public void onSubmit(AjaxRequestTarget ajaxRequestTarget, Form<?> form)
            {

            }

        });

        add(
                getSubmitButton()
        );

        add(
                new AjaxFormSubmitBehavior(this, "onsubmit")
                {
                    protected void onSubmit(AjaxRequestTarget ajaxRequestTarget)
                    {
                        info("Submitted.");
                        ajaxRequestTarget.addComponent(getTitleTextField());
                        ajaxRequestTarget.addComponent(getIdeaTextArea());
                    }

                    protected void onError(AjaxRequestTarget ajaxRequestTarget)
                    {
                        info("Error.");
                    }
                }
        );
    }

    /**
     * Method called when the form is submitted.
     */
    protected void onSubmit()
    {
        Idea idea = getModelObject();

        new IdeasService().createIdea(idea);
    }

    /**
     * Get the idea model.
     *
     * @return The idea model.
     */
    public Model<Idea> getIdeaModel()
    {
        return ideaModel;
    }

    /**
     * Set the idea model.
     * <p/>
     * This method also proxies {@link Form#setModel(org.apache.wicket.model.IModel)}
     *
     * @param ideaModel The idea model.
     */
    public void setIdeaModel(Model<Idea> ideaModel)
    {
        setModel(ideaModel);
        this.ideaModel = ideaModel;
    }

    /**
     * Get the title property model.
     *
     * @return The title property model.
     */
    public PropertyModel<String> getTitlePropertyModel()
    {
        return titlePropertyModel;
    }

    /**
     * Set the title property model.
     *
     * @param titlePropertyModel The title property model.
     */
    public void setTitlePropertyModel(PropertyModel<String> titlePropertyModel)
    {
        this.titlePropertyModel = titlePropertyModel;
    }

    /**
     * Get the idea text property model.
     *
     * @return The idea text property model.
     */
    public PropertyModel<String> getIdeaTextPropertyModel()
    {
        return ideaTextPropertyModel;
    }

    /**
     * Set the idea text property model.
     *
     * @param ideaTextPropertyModel The idea text property model.
     */
    public void setIdeaTextPropertyModel(PropertyModel<String> ideaTextPropertyModel)
    {
        this.ideaTextPropertyModel = ideaTextPropertyModel;
    }

    /**
     * Get the title text field.
     *
     * @return The title text field.
     */
    public TextField<String> getTitleTextField()
    {
        return titleTextField;
    }

    /**
     * Set the title text field.
     *
     * @param titleTextField The title text field.
     */
    public void setTitleTextField(TextField<String> titleTextField)
    {
        this.titleTextField = titleTextField;
    }

    /**
     * Get the idea text area.
     *
     * @return The idea text area.
     */
    public TextArea<String> getIdeaTextArea()
    {
        return ideaTextArea;
    }

    /**
     * Set the idea text area.
     *
     * @param ideaTextArea The idea text area.
     */
    public void setIdeaTextArea(TextArea<String> ideaTextArea)
    {
        this.ideaTextArea = ideaTextArea;
    }

    /**
     * Get the submit button.
     *
     * @return The submit button.
     */
    public AjaxButton getSubmitButton()
    {
        return submitButton;
    }

    /**
     * Set the submit button.
     *
     * @param submitButton The submit button.
     */
    public void setSubmitButton(AjaxButton submitButton)
    {
        this.submitButton = submitButton;
    }
}
