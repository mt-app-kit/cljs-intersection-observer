
(ns intersection-observer.api
    (:require [intersection-observer.side-effects :as side-effects]
              [intersection-observer.state :as state]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

; @tutorial Demo
;
; @code Element object function
; (defn get-my-element-f
;   [_]
;   (.getElementById js/document "my-element"))
;
; @code Callback function
; (defn my-callback-f
;   [intersect?]
;   (println intersect?))
;
; @code Setup observer function
; (defn setup-my-observer!
;   []
;   (setup-observer! :my-observer {:callback-f my-callback-f :get-element-f get-my-element-f}))
;
; @code Remove observer function
; (defn remove-my-observer!
;   []
;   (remove-observer! :my-observer {:get-element-f get-my-element-f}))
;
; @code Element lifecycles
; (defn my-ui
;   []
;   (reagent.core/create-class {:component-did-mount    setup-my-observer!
;                               :component-will-unmount remove-my-observer!
;                               :reagent-render (fn [] [:div {:id :my-element} "My observed element"])}))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

; @redirect (intersection-observer.side-effects/*)
(def setup-observer!  side-effects/setup-observer!)
(def remove-observer! side-effects/remove-observer!)

; @redirect (intersection-observer.state/*)
(def OBSERVERS state/OBSERVERS)
