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

                $(".settings-button", this.element).bind("click", this.controller.handleSettingsButtonClick);
    	    },

    	    handleLatestIdeasButtonClick: function ()
    	    {
    	        console.log("Show latest ideas.");
                this.sendMessage("show-latest-ideas");
                this.sendMessage("show-sub-navigation");

                $("li", this.element).removeClass("active");
                $(".latest-ideas-button", this.element).addClass("active");
    	    },

            handleShareButtonClick: function () {
                console.log("Show idea share form.");
                this.sendMessage("show-idea-share-form");

                $("li", this.element).removeClass("active");
                $(".share-your-ideas-button", this.element).addClass("active");
            },

            handleSettingsButtonClick: function ()
            {
                console.log("Show settings.");
                this.sendMessage("show-settings");
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
