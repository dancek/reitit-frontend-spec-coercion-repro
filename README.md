To reproduce the issue,

```
npm install
npx shadow-cljs watch app
```

Open a browser in http://localhost:8020/#/int/123 and look at the console to see the error. http://localhost:8020/#/spec-int/123 works.

A production build can be created with `npx shadow-cljs watch app`. You'll have to serve the contents of `public/` using the http server of your choice.
