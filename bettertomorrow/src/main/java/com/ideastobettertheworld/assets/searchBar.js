	LiveWidgets.addWidget({
    	name: 'search-bar',
    	model: {
    	    idea: "",
    	    defaultValue: "search...",
    	    searchInput: {}
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
                $(this.model.searchInput).bind("focus", this.controller.handleTextAreaFocusEvent);
                $(this.model.searchInput).bind("blur", this.controller.handleTextAreaBlurEvent);
            },
            handleTextAreaFocusEvent: function ()
            {

                this.sendMessage("search-bar-focus");

                $(this.model.searchInput).animate({
                    width: "600px"
//                    height: "35px"
                }, function () {
                    $(this.model.searchInput).select();
                }.bind(this));

                if (this.model.searchInput.value == this.model.defaultValue)
                {
                    this.model.searchInput.value = "";
                }


            },
            handleTextAreaBlurEvent: function ()
            {

                this.sendMessage("search-bar-blur");

                $(this.model.searchInput).animate({
                    width: "300px"
//                    height: "20px"
                });

                if (this.model.searchInput.value == "")
                {
                    this.model.searchInput.value = this.model.defaultValue;
                }
            },

            stopFading : function ()
            {
                $(this.element).animate({
                    marginTop: "0px",
                    opacity: 1
                }, 500);
            },

            startFading : function ()
            {
                $(this.element).animate({
                    marginTop: "65px",
                    opacity: 0
                }, 300);

            },

            handleMessage : function (message)
            {
                if (message == "idea-textarea-blur")
                {
                    this.controller.stopFading();
                }

                if (message == "idea-textarea-focus")
                {
                    this.controller.startFading();
                }

                if (message == "show-latest-ideas")
                {
                    this.controller.startFading();
                }
            }
    	},
    	constructor: function () {
            this.model.searchInput = $("input", this.element)[0];
            this.controller.bindEventsToTextArea();
            this.model.searchInput.value = this.model.defaultValue;
    	},
    	reinit: function () {

    	}
    });
