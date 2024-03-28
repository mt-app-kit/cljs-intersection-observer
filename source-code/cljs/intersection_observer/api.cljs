
(ns intersection-observer.api
    (:require [intersection-observer.side-effects :as side-effects]
              [intersection-observer.views        :as views]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

; @tutorial Demo #1
;
; @---
; ;; Element object function
; (defn get-my-element-f
;   [_]
;   (.getElementById js/document "my-element"))
;
; @---
; ;; Callback function
; (defn my-callback-f
;   [intersect?]
;   (println intersect?))
;
; @---
; ;; Setup observer function
; (defn setup-my-observer!
;   []
;   (setup-observer! :my-observer {:callback-f my-callback-f :get-element-f get-my-element-f}))
;
; @---
; ;; Remove observer function
; (defn remove-my-observer!
;   []
;   (remove-observer! :my-observer {:get-element-f get-my-element-f}))
;
; @---
; ;; Element lifecycles
; (defn my-ui
;   []
;   (reagent.core/create-class {:component-did-mount    (fn [] (setup-my-observer!)
;                               :component-will-unmount (fn [] (remove-my-observer!)
;                               :reagent-render         (fn [] [:div {:id :my-element} "My observed element"])}))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

; @tutorial Demo #2
;
; @---
; ;; Callback function
; (defn my-callback-f
;   [intersect?]
;   (println intersect?))
;
; @---
; ;; Intersection sensor
; (defn my-ui
;   []
;   [sensor :my-observer {:callback-f my-callback-f}])

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

; @redirect (intersection-observer.side-effects/*)
(def setup-observer!  side-effects/setup-observer!)
(def remove-observer! side-effects/remove-observer!)

; @redirect (intersection-observer.views/*)
(def sensor views/sensor)
