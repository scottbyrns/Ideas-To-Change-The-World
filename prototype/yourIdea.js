	LiveWidgets.addWidget({
    	name: 'your-idea',
    	model: {
    	    idea: "",
    	    defaultValue: "your idea...",
    	    ideaTextArea: {}
    	},
    	controller: {
            bindEventsToTextArea: function ()
            {
                this.controller.bindFocusEventToTextArea();
            },

            /**
             * Bind the focus behavior to the text area.
             */
            bindFocusEventToTextArea: function ()
            {
                $(this.model.ideaTextArea).bind("focus", this.controller.handleTextAreaFocusEvent);
                $(this.model.ideaTextArea).bind("blur", this.controller.handleTextAreaBlurEvent);
            },
            handleTextAreaFocusEvent: function ()
            {

                if (this.model.ideaTextArea.innerHTML == this.model.defaultValue)
                {
                    this.model.ideaTextArea.innerHTML = "";
                }
            },
            handleTextAreaBlurEvent: function ()
            {
                if (this.model.ideaTextArea.innerHTML == "")
                {
                    this.model.ideaTextArea.innerHTML = this.model.defaultValue;
                }
            }
    	},
    	constructor: function () {
            this.model.ideaTextArea = document.getElementsByTagName("textarea", this.element)[0];
            this.controller.bindEventsToTextArea();
            this.model.ideaTextArea.innerHTML = this.model.defaultValue;
    	},
    	reinit: function () {

    	}
    });
