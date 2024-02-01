import Branch from './03-Branch';
import React from 'react';
const Click = (e, msg) => {
  e.preventDefault(); //阻止事件
  console.log('你好' + msg);
};
function FunctionEvent() {
  return (
    <div>
      <Branch />
      <div>
        {/* 创建了一个匿名函数，参数为e，该函数内部调用Click函数并将e传进去 */}
        <a onClick={e => Click(e, 'lcx')} href="http://www.baidu.com">
          百度
        </a>
      </div>
    </div>
  );
}
export default FunctionEvent;
