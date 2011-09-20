	LiveWidgets.addWidget({
    	name: 'your-idea',
    	model: {
    	    idea: "",
    	    defaultValue: "your idea...",
    	    nextText: "Next...",
    	    shareText: "Share Your Idea",
    	    ideaTextArea: {},
    	    ideaTextView: {},
    	    titleTextInput: {},
    	    titleTextView: {},

    	    buttonView: {},

    	    keyUpTimer: {},

    	    textAreaHasDefaultValue : function ()
    	    {
    	        return (
    	            (this.model.ideaTextArea.value == "") ||
    	            (this.model.ideaTextArea.value == this.model.defaultValue)
    	        )
    	    }
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
                $(this.model.ideaTextArea).bind("keyup", this.controller.handleKeyUp);
            },
            handleTextAreaFocusEvent: function ()
            {

                this.sendMessage("idea-textarea-focus");

                if ($(this.model.ideaTextArea).css("height") == "88px")
                {
                    return;
                }

                $(this.element).animate({
                    height: "500px"
                });

                $(this.model.ideaTextArea).animate({
                    width: "600px",
                    height: "100px",
                    marginLeft: "-300px"
                });

                $("div.text-area-wrapper", this.element).animate({
                    height: "100px"
                });

                if (this.model.ideaTextArea.value == this.model.defaultValue)
                {
                    this.model.ideaTextArea.value = "";
                }

                $("h2", this.element).fadeOut(300);
            },

            revertTextAreaToDefaultState : function ()
            {
                    this.sendMessage("idea-textarea-blur");

                    $(this.model.ideaTextArea).animate({
                        width: "300px",
                        height: "35px",
                        marginLeft: "-150px"
                    });

                    $(this.element).animate({
                        height: "175px"
                    });

                    $("div.text-area-wrapper", this.element).animate({
                        height: "35px"
                    });

                    this.model.ideaTextArea.value = this.model.defaultValue;

                    $("h2", this.element).fadeIn(300);
            },

            commitIdeaAndMoveToNextStep : function ()
            {
                    $("div.text-area-wrapper div.idea-text", this.element).html(
                        this.model.ideaTextArea.value
                    );

                    $("div.text-area-wrapper div.idea-text", this.element)[0].setAttribute("class", "idea-text populated");

                    $(this.model.ideaTextArea, this.element).animate({
                        opacity: 0
                    }, function () {
                        $(this.model.ideaTextArea, this.element).css("display", "none");
                    }.bind(this));

                    $("div.text-area-wrapper div.idea-text", this.element).bind("click", this.controller.restoreTextArea);

                    $(this.element).animate({
                        marginTop: "5%",
                        height: "500px"
                    });

                    this.model.buttonView.innerHTML = this.model.shareText;


                    $("div.text-input-wrapper", this.element).css("display", "block").animate({
                        marginTop: "50px",
                        height: "35px",
                        opacity: 1
                    }, function () {
                        this.model.titleTextInput.focus();
                    }.bind(this));
            },

            handleTextAreaBlurEvent: function ()
            {
                if (this.model.textAreaHasDefaultValue())
                {
                    this.controller.revertTextAreaToDefaultState();
                }
                else
                {
                    this.controller.commitIdeaAndMoveToNextStep();
                }

            },

            restoreTextArea : function ()
            {

                this.model.buttonView.innerHTML = this.model.nextText;

                $("div.text-area-wrapper", this.element).unbind("click");

                $("div.text-area-wrapper div.idea-text", this.element)[0].setAttribute("class", "idea-text");

                $(this.element).animate({
                    marginTop: "15%"
                });

                $("div.text-input-wrapper", this.element).css("display", "block").animate({
                    marginTop: "0px",
                    height: "0px",
                    opacity: 0
                }, function () {
                    $("div.text-input-wrapper", this.element).css("display", "none");
                }.bind(this));

                $(this.model.ideaTextArea, this.element).css("display", "block").animate({
                    opacity: 1
                });

                this.model.ideaTextArea.focus();

            },

            handleKeyUp : function ()
            {
                clearTimeout(this.model.keyUpTimer);
                this.model.keyUpTimer = setTimeout(this.controller.autoSubmit, 800);
            },

            autoSubmit : function ()
            {

            },

            startFading : function ()
            {

                $(this.element).animate({
                    height: "0px",
                    opacity: 0
                }, 500);
            },

            stopFading : function ()
            {
                $("div.fade-wrapper", this.element).stop();
                $(this.element).animate({
                    height: "175px",
                    opacity: 1
                }, 500);

            },

            handleMessage : function (message)
            {
                if (message == "search-bar-focus")
                {
                    this.controller.startFading();
                }
                if (message == "search-bar-blur")
                {
                    this.controller.stopFading();
                }
            }
    	},
    	constructor: function () {
            this.model.ideaTextArea = document.getElementsByTagName("textarea", this.element)[0];
            this.model.ideaTextView = document.getElementsByTagName("div.idea-text", this.element)[0];


            this.model.titleTextInput = $("div.text-input-wrapper input", this.element)[0];
            this.model.titleTextView = $("div.text-input-wrapper div.title-text", this.element)[0];

            this.model.buttonView = $("a", this.element)[0];
            this.model.buttonView.innerHTML = this.model.nextText;

            this.controller.bindEventsToTextArea();
            this.model.ideaTextArea.innerHTML = this.model.defaultValue;
    	},
    	reinit: function () {

    	}
    });
