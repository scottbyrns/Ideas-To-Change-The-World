	LiveWidgets.addWidget({
    	name: 'sub-navigation',
    	model: {

    	},
    	controller: {
    	    bindClickEventsToButtons: function ()
    	    {
    	        var that = this;
                $("li", this.element).each(function (){
                    $(arguments[1]).bind("click", that.controller.highlightSelectedListItem.curry(arguments[1]));
                });
    	    },

            highlightSelectedListItem: function (element)
            {
                $("li", this.element).removeClass("active");
                $(element).addClass("active");

                var buttonLabel = $(element).html();

                if (buttonLabel == "Explore")
                {
                    alert("Coming soon.");
                }
                else if (buttonLabel == "Latest")
                {
                    this.sendMessage("hide-all-ideas-panels");
                    this.sendMessage("show-latest-ideas");
                }
                else if (buttonLabel == "Search")
                {
                    alert("Coming soon.");
                }

                else if (buttonLabel == "Trending")
                {
                    this.sendMessage("hide-all-ideas-panels");
                    this.sendMessage("show-trending-ideas");
                }
            },

            handleMessage: function (message)
            {
                if (message == "show-sub-navigation")
                {
                    this.controller.showPanel();
                }

                if (message == "show-idea-share-form")
                {
                    this.controller.hidePanel();
                }

                if (message == "show-settings")
                {
//                    this.controller.showPanel();
                }
            },

            showPanel: function ()
            {
                $(this.element).show().css({
                    height: "0px"
                }).animate({
                    height: "45px"
                }, 100);
            },

            hidePanel: function ()
            {
                $(this.element).animate({
                    height: "0px"
                }, 100, function () {
                    $(this.element).hide();
                }.bind(this));
            }
    	},
    	constructor: function () {
            this.controller.bindClickEventsToButtons();
    	},
    	reinit: function () {

    	}
    });
