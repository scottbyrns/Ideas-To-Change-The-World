	LiveWidgets.addWidget({
    	name: 'controls',
    	model: {

    	},
    	controller: {
    	    bindEventsToControls : function ()
    	    {
    	        console.log("Bind events to controls.");
                $(".latest-ideas-button", this.element).bind("click", this.controller.handleLatestIdeasButtonClick);
    	    },

    	    handleLatestIdeasButtonClick: function ()
    	    {
    	        console.log("Show latest ideas.");
                this.sendMessage("show-latest-ideas");
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
