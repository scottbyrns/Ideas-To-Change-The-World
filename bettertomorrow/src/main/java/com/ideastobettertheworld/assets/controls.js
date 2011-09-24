	LiveWidgets.addWidget({
    	name: 'controls',
    	model: {

    	},
    	controller: {
    	    bindEventsToControls : function ()
    	    {
    	        console.log("Bind events to controls.");
                $(".latest-ideas-button", this.element).bind("click", this.controller.handleLatestIdeasButtonClick);
                $(".share-your-ideas-button", this.element).bind("click", this.controller.handleShareButtonClick);
                $(".search-button", this.element).bind("click", this.controller.handleShareButtonClick);
    	    },

    	    handleLatestIdeasButtonClick: function ()
    	    {
    	        console.log("Show latest ideas.");
                this.sendMessage("show-latest-ideas");
    	    },

            handleShareButtonClick: function () {
                console.log("Show idea share form.");
                this.sendMessage("show-idea-share-form");
            },

            handleMessage: function (message)
            {

            }
    	},
    	constructor: function () {

            this.controller.bindEventsToControls();
    	},
    	reinit: function () {

    	}
    });
