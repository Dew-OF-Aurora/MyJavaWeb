<template>
    <svg class="svg-icon" aria-hidden="true">
        <use :xlink:href="icon"></use>
    </svg>
</template>

<script>
import { defineProps } from 'vue'
const props = defineProps({
    icon: {
        type:String,
        required: true
    }
})
const iconName = computed(()=>{
    return `#icon=${props.icon}`
})
</script>

<style lang="scss" scoped>
.svg-icon{
    width: 1em;
    height: 1em;
    vertical-align: -0.015em;
    fill: currentColor;
    overflow: hidden;
}
</style>