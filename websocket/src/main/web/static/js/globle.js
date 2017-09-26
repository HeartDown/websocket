function getUrl() {
    var href = window.location.pathname;
    href = href.substr(0, href.indexOf("/", 1));
    return href;
}

importCss("/static/css/iview.css");
importJs("/static/js/jquery-3.1.1.min.js");
importJs("/static/js/vue.min.js");
importJs("/static/js/iview.min.js");
importJs("/static/js/layer/layer.js");
importJs("/static/js/axios.js");

function getRootUrl() {
    return window.location.protocol+window.location.host;
}
function importCss(cssFilePath) {
    document.write('<link rel="stylesheet" href="'+cssFilePath+'"/>')
}
function importJs(jsFilePath) {
    document.write('<script language="javascript" src="' + jsFilePath + '"></script>');
}