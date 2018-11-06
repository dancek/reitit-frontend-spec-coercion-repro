(ns starter.browser
  (:require [cljs.pprint :refer [pprint]]
            [reitit.frontend :as rf]
            [reitit.frontend.easy :as rfe]
            [reitit.coercion.spec :as rspec]
            [spec-tools.spec :as spec]))

(def routes
  (rf/router
    [["/" {:name ::root}]
     ["/int/:id" {:name ::int
                  :parameters {:path {:id int?}}}]
     ["/spec-int/:id" {:name ::spec-int
                       :parameters {:path {:id spec/int?}}}]]
    {:data {:coercion rspec/coercion}}))

(defn log-match [match]
  (let [data (with-out-str (pprint match))]
    (js/console.log data)))

(defn ^:export init []
  (rfe/start!
    routes
    (fn [m] (log-match m))
    {:use-fragment true}))
