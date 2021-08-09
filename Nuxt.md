## Nuxt

### 安装并创建项目：

```sh
$ npm install -g vue-cli
$ vue init nuxt-community/starter-template nuxt-demo
$ cd nuxt-demo
$ npm install
```

生成的目录结构：

```sh
.
├── assets
│   └── README.md
├── components
│   ├── AppLogo.vue
│   └── README.md
├── layouts
│   ├── default.vue
│   └── README.md
├── middleware
│   └── README.md
├── nuxt.config.js
├── package.json
├── pages
│   ├── index.vue
│   └── README.md
├── plugins
│   └── README.md
├── README.md
├── static
│   ├── favicon.ico
│   └── README.md
└── store
    └── README.md

```

```sh
nuxt-demo/
├── api/                                  //- 接口
│   └── index.js
├── assets/                               //- 需要编译的静态资源，如 scss、less、stylus
│   ├── images/                           //- 图片
│   └── styles/                           //- 样式
├── build/                                //- 自定义的一些编译配置
├── components/                           //- 公用的组件
│   ├── dm-toast.vue                      //- 全局组件`dm-toast`
│   └── ...
├── data/                                 //- 静态数据
├── layouts/                              //- 布局
│   ├── components/
│   │   ├── dm-footer.vue                 //- 公用header
│   │   └── dm-header.vue                 //- 公用footer
│   └── default.vue                       //- 默认布局
├── middleware/                           //- 中间件
├── mixins/                               //- Vue mixins
├── pages/                                //- 页面
│   ├── index.vue                         //- 主页
│   └── ...
├── plugins/                              //- vue插件
│   └── dm-tracker.js/                    //- 挂载utils/tracker.js
├── static/                               //- 无需编译处理的静态资源
│   └── images/                           //- 这里存放了一些通过数据循环出来的图片
├── store/                                //- vuex
│   └── index.js
├── utils/                                //- 工具集
│   ├── index.js
│   ├── http.js                           //- axios
│   ├── tracker.js                        //- PV统计
│   └── tracker-uitl.js
├── vendor/                               //- 第三方的库和插件
│   └── index.js
├── nuxt.config.js                        //- Nuxt.js配置文件
├── seo.config.js                         //- SEO相关配置文件
├── package-lock.json                     //- npm的版本锁
├── package.json
└── README.md
```

### 第二种创建方式：

```sh
sudo yarn config set registry https://registry.npm.taobao.org
sudo yarn create nuxt-app topology-vue
```

```sh
Generating Nuxt.js project in nuxt-demo-2
? Project name nuxt-demo-2
? Project description My fabulous Nuxt.js project
? Author name jingyoushui
? Choose the package manager Yarn
? Choose UI framework Element
? Choose custom server framework None (Recommended)
? Choose Nuxt.js modules (Press <space> to select, <a> to toggle all, <i> to inv
ert selection)
? Choose linting tools (Press <space> to select, <a> to toggle all, <i> to inver
t selection)
? Choose test framework None
? Choose rendering mode Universal (SSR)
? Choose development tools (Press <space> to select, <a> to toggle all, <i> to i
nvert selection)jsconfig.json (Recommended for VS Code)

🎉  Successfully created project nuxt-demo-2

```



## React

安装UMiJS

```sh
npm install yarn -g
yarn global add umi
```

安装UmiJS脚手架

```sh
mkdir react-demo
cd react-demo
 yarn create umi
 
 // 创建项目文件后，安装依赖包
 yarn
```

```sh
? Select the boilerplate type ant-design-pro
? Which language do you want to use? TypeScript
> git clone https://github.com/ant-design/ant-design-pro --depth=1 /home/lixing/vue-2/react-demo
> Clean up...
✨ File Generate Done
Done in 28.29s.

```

```
.
├── config
│   ├── config.ts
│   ├── defaultSettings.ts
│   ├── plugin.config.ts
│   └── themePluginConfig.ts
├── jest.config.js
├── jest-puppeteer.config.js
├── jsconfig.json
├── mock
│   ├── notices.ts
│   ├── route.ts
│   └── user.ts
├── package.json
├── public
│   ├── favicon.png
│   └── icons
│       ├── icon-128x128.png
│       ├── icon-192x192.png
│       └── icon-512x512.png
├── README.md
├── src
│   ├── assets
│   │   └── logo.svg
│   ├── components
│   │   ├── Authorized
│   │   │   ├── AuthorizedRoute.tsx
│   │   │   ├── Authorized.tsx
│   │   │   ├── CheckPermissions.tsx
│   │   │   ├── index.tsx
│   │   │   ├── PromiseRender.tsx
│   │   │   ├── renderAuthorize.ts
│   │   │   └── Secured.tsx
│   │   ├── GlobalHeader
│   │   │   ├── AvatarDropdown.tsx
│   │   │   ├── index.less
│   │   │   ├── NoticeIconView.tsx
│   │   │   └── RightContent.tsx
│   │   ├── HeaderDropdown
│   │   │   ├── index.less
│   │   │   └── index.tsx
│   │   ├── HeaderSearch
│   │   │   ├── index.less
│   │   │   └── index.tsx
│   │   ├── NoticeIcon
│   │   │   ├── index.less
│   │   │   ├── index.tsx
│   │   │   ├── NoticeList.less
│   │   │   └── NoticeList.tsx
│   │   ├── PageLoading
│   │   │   └── index.tsx
│   │   └── SelectLang
│   │       ├── index.less
│   │       └── index.tsx
│   ├── e2e
│   │   ├── baseLayout.e2e.js
│   │   ├── __mocks__
│   │   │   └── antd-pro-merge-less.js
│   │   └── topMenu.e2e.js
│   ├── global.less
│   ├── global.tsx
│   ├── layouts
│   │   ├── BasicLayout.tsx
│   │   ├── BlankLayout.tsx
│   │   ├── SecurityLayout.tsx
│   │   ├── UserLayout.less
│   │   └── UserLayout.tsx
│   ├── locales
│   │   ├── en-US
│   │   │   ├── component.ts
│   │   │   ├── globalHeader.ts
│   │   │   ├── menu.ts
│   │   │   ├── pwa.ts
│   │   │   ├── settingDrawer.ts
│   │   │   └── settings.ts
│   │   ├── en-US.ts
│   │   ├── pt-BR
│   │   │   ├── component.ts
│   │   │   ├── globalHeader.ts
│   │   │   ├── menu.ts
│   │   │   ├── pwa.ts
│   │   │   ├── settingDrawer.ts
│   │   │   └── settings.ts
│   │   ├── pt-BR.ts
│   │   ├── zh-CN
│   │   │   ├── component.ts
│   │   │   ├── globalHeader.ts
│   │   │   ├── menu.ts
│   │   │   ├── pwa.ts
│   │   │   ├── settingDrawer.ts
│   │   │   └── settings.ts
│   │   ├── zh-CN.ts
│   │   ├── zh-TW
│   │   │   ├── component.ts
│   │   │   ├── globalHeader.ts
│   │   │   ├── menu.ts
│   │   │   ├── pwa.ts
│   │   │   ├── settingDrawer.ts
│   │   │   └── settings.ts
│   │   └── zh-TW.ts
│   ├── manifest.json
│   ├── models
│   │   ├── connect.d.ts
│   │   ├── global.ts
│   │   ├── login.ts
│   │   ├── setting.ts
│   │   └── user.ts
│   ├── pages
│   │   ├── 404.tsx
│   │   ├── Admin.tsx
│   │   ├── Authorized.tsx
│   │   ├── document.ejs
│   │   ├── user
│   │   │   └── login
│   │   │       ├── components
│   │   │       │   └── Login
│   │   │       │       ├── index.less
│   │   │       │       ├── index.tsx
│   │   │       │       ├── LoginContext.tsx
│   │   │       │       ├── LoginItem.tsx
│   │   │       │       ├── LoginSubmit.tsx
│   │   │       │       ├── LoginTab.tsx
│   │   │       │       └── map.tsx
│   │   │       ├── index.tsx
│   │   │       ├── locales
│   │   │       │   ├── en-US.ts
│   │   │       │   ├── zh-CN.ts
│   │   │       │   └── zh-TW.ts
│   │   │       └── style.less
│   │   ├── Welcome.less
│   │   └── Welcome.tsx
│   ├── services
│   │   ├── login.ts
│   │   └── user.ts
│   ├── service-worker.js
│   ├── typings.d.ts
│   └── utils
│       ├── authority.test.ts
│       ├── authority.ts
│       ├── Authorized.ts
│       ├── request.ts
│       ├── utils.less
│       ├── utils.test.ts
│       └── utils.ts
├── tests
│   ├── run-tests.js
│   └── setupTests.js
└── tsconfig.json


```

## Angular

安装angular cli

```sh
sudo npm install -g @angular/cli
```

创建工作空间和初始应用

```sh
ng new angular-demo
```

运行

```
cd angular-demo
ng server --open
```

