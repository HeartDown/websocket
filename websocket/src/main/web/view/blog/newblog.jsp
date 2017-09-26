<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Login</title>
    <script type="text/javascript" src="../../static/js/globle.js"></script>
    <link rel="stylesheet" href="../../static/css/syle.css"/>
    <link rel="stylesheet" href="../../static/css/wangEditor.css"/>
</head>
<body>

<div id="app">
    <header>
        <Row>
            <i-col span="4" offset="2">
                个人博客
            </i-col>
            <i-col span="4" offset="14">
                {{curUser.username}}
            </i-col>
        </Row>
    </header>
    <Row justify="center">
        <i-col span="18">
            <i-menu mode="horizontal" class="ulblog" theme="null">
                <Menu-item name="1">
                    <Icon type="ios-paper"></Icon>
                    <a href="/seeBlog">博客首页</a>
                </Menu-item>
                <Menu-item name="2">
                    <Icon type="ios-people"></Icon>
                    <a href="/seeBlog">个人中心</a>
                </Menu-item>
                <Menu-item name="3">
                    <Icon type="edit"></Icon>
                    <a href="#">新博客</a>
                </Menu-item>
            </i-menu>
        </i-col>
        <i-col class="blogstatus">
            随笔-{{suibinumber}}&nbsp;
            文章-{{textnumber}}&nbsp;
            草稿-{{caogaonumber}}
        </i-col>
    </Row>
    <Row>
        <i-col span="4" class="ulmenu">
            <i-menu theme="dark" class="menugroup">
                <Menu-group title="操作">
                    <Menu-item name="1" on-select="addNew">
                        <Icon type="document-text"></Icon>
                        添加新随笔
                    </Menu-item>
                    <Menu-item name="2">
                        <Icon type="chatbubbles"></Icon>
                        草稿箱
                    </Menu-item>
                    <Menu-item name="3">
                        <Icon type="chatbubbles"></Icon>
                        设置默认编辑器
                    </Menu-item>
                    <Menu-item name="4">
                        <Icon type="chatbubbles"></Icon>
                        备份
                    </Menu-item>
                </Menu-group>
                <Menu-group title="分类">
                    <Menu-item name="5">
                        <Icon type="document-text"></Icon>
                        编辑分类
                    </Menu-item>
                    <Menu-item name="6">
                        <Icon type="chatbubbles"></Icon>
                        所有分类
                    </Menu-item>
                    <Menu-item name="7">
                        <Icon type="chatbubbles"></Icon>
                        未分类
                    </Menu-item>

                </Menu-group>
            </i-menu>
        </i-col>
        <i-col span="20" class="mainblog">
            <Row>
                <i-col span="15">
                    <i-input v-model="blog.title">
                        <span slot="prepend">标题：</span>
                    </i-input>
                </i-col>
                <i-col span="5" offset="4">
                    <i-input v-model="blog.slug">
                        <span slot="prepend">内容概述：</span>
                    </i-input>
                </i-col>
            </Row>
            <Row style="margin-top: 30px;">
                <i-col>
                    <h2>内容：</h2>
                    <div id="div1">
                        <p>请输入内容...</p>
                    </div>
                </i-col>
            </Row>
            <Row>
                <i-col>
                    <Collapse v-model="collapse1" accordion>
                        <Panel name="1">
                            个人分类
                            <div slot="content">
                                <Checkbox-group v-model="blog.type">
                                    <Checkbox label="javascript">
                                        <Icon type="social-javascript"></Icon>
                                        <span>javascript</span>
                                    </Checkbox>
                                    <Checkbox label="nodejs">
                                        <Icon type="social-nodejs"></Icon>
                                        <span>nodejs</span>
                                    </Checkbox>
                                    <Checkbox label="windows">
                                        <Icon type="social-windows"></Icon>
                                        <span>windows</span>
                                    </Checkbox>
                                </Checkbox-group>
                            </div>
                        </Panel>
                        <Panel name="2">
                            发布选项
                            <p slot="content">
                                <Checkbox-group v-model="blog.type">
                                    <Checkbox label="home">
                                        <Icon type="social-javascript"></Icon>
                                        <span>发布至首页</span>
                                    </Checkbox>
                                </Checkbox-group>
                                【发文说明】
                                首页（即网站首页）只能发布原创的、高质量的、能让读者从中学到东西的内容。
                                如果博文质量不符合首页要求，会被工作人员移出首页，望理解。
                            </p>
                        </Panel>
                        <Panel name="3">
                            网站分类
                            <div slot="content">
                                <Checkbox-group v-model="blog.social">
                                    <Checkbox label="twitter">
                                        <Icon type="social-twitter"></Icon>
                                        <span>Twitter</span>
                                    </Checkbox>
                                    <Checkbox label="facebook">
                                        <Icon type="social-facebook"></Icon>
                                        <span>Facebook</span>
                                    </Checkbox>
                                    <Checkbox label="github">
                                        <Icon type="social-github"></Icon>
                                        <span>Github</span>
                                    </Checkbox>
                                    <Checkbox label="android">
                                        <Icon type="social-android"></Icon>
                                        <span>android</span>
                                    </Checkbox>
                                    <Checkbox label="ios">
                                        <Icon type="social-apple"></Icon>
                                        <span>ios</span>
                                    </Checkbox>
                                    <Checkbox label="python">
                                        <Icon type="social-python"></Icon>
                                        <span>python</span>
                                    </Checkbox>
                                    <Checkbox label="markdown">
                                        <Icon type="social-markdown"></Icon>
                                        <span>markdown</span>
                                    </Checkbox>
                                </Checkbox-group>
                            </div>
                        </Panel>
                    </Collapse>
                </i-col>
            </Row>
            <Row>
                <i-col span="4">
                    <Upload
                            multiple
                            action="postFiles" :before-upload="handleUpload" ref="upload" :on-success="handleSuccess"
                            :format="['jpg','jpeg','png']">
                        <i-button type="ghost" icon="ios-cloud-upload-outline">上传博客封面</i-button>
                    </Upload>
                    <div v-if="file !== null">待上传图片：{{ file.name }}
                        <i-button type="button" @click="uploads" :loading="loadingStatus">{{ loadingStatus ? '上传中' : '点击上传' }}
                        </i-button>
                    </div>
                 </i-col>
            </Row>
            <Row>
                <i-col span="4" offset="8">
                    <i-button type="primary" v-on:click="unloadblog">保存</i-button>
                </i-col>
                <i-col span="4" offset="1">
                    <i-button type="primary">重置</i-button>
                </i-col>
            </Row>
        </i-col>
    </Row>
</div>
<footer style="padding: 3em 0;text-align: center;">
    <p>
        <larger>© zh博客. <br>学习参考使用</larger>
    </p>
</footer>
<script type="text/javascript" src="/static/js/wangEditor.js"></script>
<script type="text/javascript" src="../../static/js/newblog.js"></script>
<footer></footer>
</body>
<script>

</script>
</html>